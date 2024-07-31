package com.example.doolhof.domeinen;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;

@Entity(name = "tiles")
public class Tile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Treasure treasure; // item (schat? ja/nee object)

    //@JsonIgnore
    //@ManyToOne
    //@JoinColumn(name = "game_id")
    //private Game game;
    @JsonIgnore
    @ManyToMany(mappedBy = "tiles")
    private Set<Game> games;

    //@ManyToOne
    //@JoinColumn(name = "board_id")
    //private Board board;


    @Column(name = "is_wall_left")
    private boolean isWallLeft;

    @Column(name = "is_wall_l_right")
    private boolean isWallLRight;

    @Column(name = "is_wall_l_top")
    private boolean isWallLTop;

    @Column(name = "is_wall_l_bottom")
    private boolean isWallLBottom;


    // Todo: hieronder properties kunnen problemen zorgen met veel op veel relatie met Game
    // alles naar tussenentiteit verplaatsen
    @Column(name = "POSITION_X")
    private int positionX;

    @Column(name = "POSITION_Y")
    private int positionY;

    @Enumerated(EnumType.STRING)
    private Path path;


    public Tile() {
    }

    public Tile(Path path) {
        this.treasure = null;
        this.path = path;
        configureTileSides(path); // default at initial
    }


    public Tile(Path path, Treasure treasure) {
        this.treasure = treasure;
        this.path = path;
        configureTileSides(path);
    }

    public Tile(Path path, Treasure treasure, int direction) {
        this.treasure = treasure;
        this.path = path;
        configureTileSides(path);
    }


    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    //    configureTileSides(path); // default at initial
    //}


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isWallLeft() {
        return isWallLeft;
    }

    public void setWallLeft(boolean wallLeft) {
        isWallLeft = wallLeft;
    }

    public boolean isWallLRight() {
        return isWallLRight;
    }

    public void setWallLRight(boolean wallLRight) {
        isWallLRight = wallLRight;
    }

    public boolean isWallLBottom() {
        return isWallLBottom;
    }

    public void setWallLBottom(boolean wallLBottom) {
        isWallLBottom = wallLBottom;
    }

    public boolean isWallLTop() {
        return isWallLTop;
    }

    public void setWallLTop(boolean wallLTop) {
        isWallLTop = wallLTop;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    // DEFAULT position of path / roads
    private void configureTileSides(Path path) {
        switch (path) {
            case STRAIGHT:
                this.isWallLeft = false; // muur
                this.isWallLRight = false; // muur
                this.isWallLTop = true; // doorgang
                this.isWallLBottom = true; // doorgang
                break;
            case CORNER:
                this.isWallLeft = true;
                this.isWallLRight = false;
                this.isWallLTop = true;
                this.isWallLBottom = false;
                break;
            case CROSSPOINT:
                this.isWallLeft = true;
                this.isWallLRight = false;
                this.isWallLTop = true;
                this.isWallLBottom = true;
                break;
        }
    }


    public Treasure getTreasure() {
        return treasure;
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

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

     */

    /*
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

     */
}
