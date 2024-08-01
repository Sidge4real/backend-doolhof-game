package com.example.doolhof.domeinen;

import com.example.doolhof.repository.TreasureRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "tiles")
public class Tile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne
    private Treasure treasure;

    @JsonIgnore
    @ManyToOne
    private Game game;

    @Column(name = "is_wall_left")
    private boolean isWallLeft;

    @Column(name = "is_wall_right")
    private boolean isWallRight;

    @Column(name = "is_wall_top")
    private boolean isWallTop;

    @Column(name = "is_wall_bottom")
    private boolean isWallBottom;

    @Column(name = "position_x")
    private int positionX;

    @Column(name = "position_y")
    private int positionY;

    @Enumerated(EnumType.STRING)
    private Path path;

    // Default constructor (required by JPA)
    public Tile() {
    }

    // Constructor for creating Tile with a specific path
    public Tile(Path path) {
        this.path = path;
        configureTileSides(path);
    }

    // Constructor for creating Tile with a specific path and treasure
    public Tile(Path path, Treasure treasure) {
        this.treasure = treasure;
        this.path = path;
        configureTileSides(path);
    }

    // Getters and setters
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

    public boolean isWallRight() {
        return isWallRight;
    }

    public void setWallRight(boolean wallRight) {
        isWallRight = wallRight;
    }

    public boolean isWallTop() {
        return isWallTop;
    }

    public void setWallTop(boolean wallTop) {
        isWallTop = wallTop;
    }

    public boolean isWallBottom() {
        return isWallBottom;
    }

    public void setWallBottom(boolean wallBottom) {
        isWallBottom = wallBottom;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
        //configureTileSides(path);
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    // Configure the sides of the tile based on the path

    private void configureTileSides(Path path) {
        switch (path) {
            case STRAIGHT:
                this.isWallLeft = false;
                this.isWallRight = false;
                this.isWallTop = true;
                this.isWallBottom = true;
                break;
            case CORNER:
                this.isWallLeft = true;
                this.isWallRight = false;
                this.isWallTop = true;
                this.isWallBottom = false;
                break;
            case CROSSPOINT:
                this.isWallLeft = true;
                this.isWallRight = false;
                this.isWallTop = true;
                this.isWallBottom = true;
                break;
        }
    }


}