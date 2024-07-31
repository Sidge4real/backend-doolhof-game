package com.example.doolhof.controller.request;

import java.util.UUID;

public class AcceptInviteRequest {
    private UUID game_id;

    public UUID getGame_id() {
        return game_id;
    }

    public void setGame_id(UUID game_id) {
        this.game_id = game_id;
    }
}
