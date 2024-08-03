package com.example.doolhof.controller.request;

import java.util.UUID;

public class MoveTileRequest {
    private UUID playerId;
    private int tilePosX;
    private int tilePosY;
    private String direction;

    public int getTilePosX() {
        return tilePosX;
    }

    public void setTilePosX(int tilePosX) {
        this.tilePosX = tilePosX;
    }

    public int getTilePosY() {
        return tilePosY;
    }

    public void setTilePosY(int tilePosY) {
        this.tilePosY = tilePosY;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }


}
