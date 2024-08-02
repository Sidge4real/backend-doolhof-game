package com.example.doolhof.domeinen;

import com.example.doolhof.exception.NotFoundException;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    // één game heeft meerdere spelers
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Player> players;


    @Column(nullable = true)
    private int round;


    @Enumerated(EnumType.STRING)
    private GameState gamestate;


    @ManyToMany
    @JoinTable(
            name = "game_cards",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private Set<Card> cards;


    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tile> tiles;


    // één game heeft één speler aan de beurt
    @OneToOne
    private Player currentPlayer;

    public Game() {
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }


    public GameState getGameState() {
        return this.gamestate;
    }

    public void setGameState(GameState gamestate) {
        this.gamestate = gamestate;
    }

    public Set<Card> getCards() {
        return this.cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Tile getTile(int x, int y){
        for(Tile tile : getTiles()){
            if(tile.getPositionX() == x && tile.getPositionY() == y){
                return tile;
            }
        }
        throw new NotFoundException("Gevraagde tegel is niet gevonden!");
    }
}
