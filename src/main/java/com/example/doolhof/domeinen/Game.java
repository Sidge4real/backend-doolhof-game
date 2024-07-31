package com.example.doolhof.domeinen;

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

    // één game heeft één bord
    //@OneToOne(cascade = CascadeType.ALL)
    //private Board board;


    @Enumerated(EnumType.STRING)
    private GameState gamestate;

    // één game heeft meerdere kaarten
    // @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    // private List<Card> cards;

    @ManyToMany
    @JoinTable(
            name = "game_cards",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id")
    )
    private Set<Card> cards;

    // één game heeft meerdere tegels
    //@OneToMany(mappedBy = "game", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Tile> tiles;
    @ManyToMany
    @JoinTable(
            name = "game_tiles",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "tile_id")
    )
    private Set<Tile> tiles;


    // één game heeft één speler aan de beurt
    // speler aan de beurt
    @OneToOne
    private Player currentPlayer;

    // Board  -> tiles

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


    public Set<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(Set<Tile> tiles) {
        this.tiles = tiles;
    }

    /*
    public List<Tile> getTiles() {
        return this.tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

     */


        /*
    public Board getBoard(){
        return this.board;
    }

    // is dit nodig? nog te bekijken
    public void setBoard(Board board){
        this.board = board;
    }

         */

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


}
