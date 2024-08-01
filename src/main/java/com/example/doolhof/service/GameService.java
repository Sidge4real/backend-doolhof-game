package com.example.doolhof.service;

import com.example.doolhof.domeinen.*;
import com.example.doolhof.exception.NotAuthorizedException;
import com.example.doolhof.exception.NotFoundException;
import com.example.doolhof.repository.CardRepository;
import com.example.doolhof.repository.GameRepository;
import com.example.doolhof.repository.PlayerRepository;
import com.example.doolhof.repository.TileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Transactional
public class GameService {
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final CardRepository cardRepository;
    private final TileRepository tileRepository;
    private final TileService tileService;

    public GameService(GameRepository gameRepository, PlayerRepository playerRepository, CardRepository cardRepository, TileRepository tileRepository, TileService tileService) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.cardRepository = cardRepository;
        this.tileRepository = tileRepository;
        this.tileService = tileService;
    }

    // onvolledig, zonder controle
    public Optional<Game> getGame(UUID gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        if(game.isEmpty()){
            throw new NotFoundException("Spel bestaat niet");
        }
        return game;
    }

    // Nog afwerken!
    public Game createGame(UUID player_id) {
        Game game = new Game();
        game.setGameState(GameState.NOT_STARTED);
        Optional<Player> currentPlayer = playerRepository.findById(player_id);
        if (currentPlayer.isEmpty()) {
            throw new NotFoundException("Player does not exist");
        }

        List<Tile> tiles = tileService.createTiles();

        if(tileService.checkup()){
            tileService.reset();
        }
        else{
            throw new RuntimeException("Er treedte een probleem op in het finaliseren van de tegels");
        }

        game.setTiles(tiles);

        List<Player> players = new ArrayList<>();
        players.add(currentPlayer.get());
        game.setPlayers(players);
        List<Card> cardList = cardRepository.findAll();
        Set<Card> cards = new HashSet<>(cardList);

        game.setCards(cards);

        game = gameRepository.save(game);

        return game;
    }

    public void deleteGame(UUID game_id) {
        Optional<Game> game = gameRepository.findById(game_id);
        if (game.isEmpty()) {
            throw new NotFoundException("Spel is niet gevonden");
        }
        gameRepository.delete(game.get());
    }

    public void invitePlayer(UUID game_id, UUID senderId, String invitee){
        Optional<Game> reqGame = gameRepository.findById(game_id);
        if(reqGame.isEmpty()) {
            throw new NotFoundException("Spel bestaat niet!");
        }
        Game game = reqGame.get();
        Optional<Player> sender = playerRepository.findById(senderId);
        if(sender.isEmpty()){
            throw new NotFoundException(("Speler bestaat niet!"));
        }
        List<Player> players = game.getPlayers();
        if(!sender.equals(players.get(0))){
           throw new RuntimeException("Speler is niet de admin van de game!");
        }

        Optional<Player> reqInvitee = playerRepository.findByName(invitee); // afwerken! Nog niet klaar...
        if(reqInvitee.isEmpty()){
            throw new NotFoundException("De uitgenodigde speler bestaat niet");
        }
        Player inviteePlayer = reqInvitee.get();
        Set<String> inviteeList = inviteePlayer.getInvites();
        inviteeList.add(game_id.toString());
        inviteePlayer.setInvites(inviteeList);
        playerRepository.save(inviteePlayer);
    }

    public Game acceptInvite(UUID game_id, UUID player_id){
        Optional<Game> reqGame = gameRepository.findById(game_id);
        if(reqGame.isEmpty()){
            throw new NotFoundException("Spel bestaat niet");
        }
        Optional<Player> player = playerRepository.findById(player_id);
        if(player.isEmpty()){
            throw new NotFoundException("Speler bestaat niet");
        }
        Game game = reqGame.get();
        List<Player> players = game.getPlayers();
        players.add(player.get());
        game.setPlayers(players);

        gameRepository.save(game);

        return game;
    }


    public Game startGame(UUID game_id, UUID player_id){
        Optional<Game> reqGame = gameRepository.findById(game_id);
        if(reqGame.isEmpty()){
            throw new NotFoundException("Spel bestaat nog niet");
        }
        Optional<Player> reqPlayer = playerRepository.findById(player_id);
        if(reqPlayer.isEmpty()){
            throw new NotFoundException("Speler bestaat niet");
        }
        Game game = reqGame.get();
        Player player = reqPlayer.get();

        // controle speler is admin?
        List<Player> players = game.getPlayers();
        if(!players.get(0).equals(player)){
            throw new NotAuthorizedException("Deze speler heeft geen admin rechten");
        }
        // Meer dan 2 spelers nodig
        if(players.size() < 2 || players.size() > 4){
            throw new NotAuthorizedException(("Er zijn nog niet genoeg spelers aanwezig"));
        }
        game.setGameState(GameState.STARTED);

        Set<Card> gameCards = game.getCards();
        List<Card> cardList = new ArrayList<>(gameCards);
        Collections.shuffle(cardList);

        int numberOfPlayers = players.size();
        int cardsPerPlayer = 6;
        int totalCardsNeeded = numberOfPlayers * cardsPerPlayer;

        if (totalCardsNeeded > cardList.size()) {
            throw new IllegalArgumentException("Not enough cards to distribute to each player");
        }

        for (Player selectedPlayer : players) {
            Set<Card> playerCards = new HashSet<>();
            for (int i = 0; i < cardsPerPlayer; i++) {
                playerCards.add(cardList.remove(0));
            }
            selectedPlayer.setCards(playerCards);
        }
        gameRepository.save(game);
        return game;
    }



    public Game takeAStep(UUID game_id, UUID player_id, List<Step> steps){
        Optional<Game> reqGame = gameRepository.findById(game_id);
        Optional<Player> reqPlayer = playerRepository.findById(player_id);

        if(reqGame.isEmpty()){
            throw new NotFoundException("spel niet gevonden");
        }
        if(reqPlayer.isEmpty()){
            throw new NotFoundException("speler niet gevonden");
        }
        Game game = reqGame.get();
        Player player = reqPlayer.get();
        List<Player> gamePlayers = game.getPlayers();

        for(Player checkPlayer : gamePlayers){
            if(!player.equals(checkPlayer)){
                throw new NotAuthorizedException("Speler neemt geen deel aan het spel!");
            }
        }
        if(game.getRound() <= player.getLatestRoundPlayed())
        {
            throw new NotAuthorizedException("Speler heeft ronde al gespeeeld");
        }
        // controle mag die stap gedaan worden?
        for(Step step : steps){

        }

        return null;
    }


}
