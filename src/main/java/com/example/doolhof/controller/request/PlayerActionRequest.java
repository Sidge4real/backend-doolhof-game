package com.example.doolhof.controller.request;


import com.example.doolhof.domeinen.Step;

import java.util.List;
import java.util.UUID;


public class PlayerActionRequest {
    private UUID playerId;
    private List<Step> steps;

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }
}

