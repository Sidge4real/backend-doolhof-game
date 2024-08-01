package com.example.doolhof.domeinen;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonIgnore
    @ManyToMany(mappedBy = "cards")
    private Set<Game> games;

    //@ManyToOne
    //@JoinColumn(name = "player_id")
    //private Player player;

    @JsonIgnore
    @ManyToMany(mappedBy = "cards")
    private Set<Player> players;

    // item (schat object)
    @OneToOne
    private Treasure treasure;

    public Card() {
    }

    public Treasure getTreasure() {
        return this.treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    /*
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

     */
}
