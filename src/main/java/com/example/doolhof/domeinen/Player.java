package com.example.doolhof.domeinen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    // één speler heeft meerdere kaarten
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> cards;

    @OneToOne
    private Card current_objective; // schat die hij/zij moet zoeken

    @OneToOne
    private Tile tile; // 1 tegel per speler

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @Column(name = "name", unique = true)
    private String name;

    // Afwerken? Zie oo PlayerActionRequest
    private List<Step> steps;

    @Column()
    private boolean isLoggedIn;

    @Column(name = "POSITION_X")
    private int positionX;

    @Column(name = "POSITION_Y")
    private int positionY;
    // current card  )-> schat die we zoeken


    // lijst van verschillende gameId die speler kan deelnemen
    @ElementCollection
    @CollectionTable(name = "invites", joinColumns = @JoinColumn(name = "my_entity_id"))
    @Column(name = "invite", unique = true)
    private Set<String> invites;


    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Card getCurrent_objective() {
        return current_objective;
    }

    public void setCurrent_objective(Card current_objective) {
        this.current_objective = current_objective;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public Set<String> getInvites() {
        return invites;
    }

    public void setInvites(Set<String> invites) {
        this.invites = invites;
    }
}
