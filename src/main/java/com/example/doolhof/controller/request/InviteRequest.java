package com.example.doolhof.controller.request;

import java.util.UUID;

public class InviteRequest {

    private UUID senderId; // id van speler die uitnodiging stuurt
    private String name; // naam van de uitgenodigde speler


    // getters and setters
    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
