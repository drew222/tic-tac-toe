package com.example.helloworld;

/**
 * Created by drewzoellner on 2/18/16.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
//import org.hibernate.validator.constraints.Length;

public class Move {
    private long id;
    private int player;
    private int moveSpot;
    private String message;

    public Move() {
        // Jackson deserialization
    }

    public Move(long id, int move, int player, String message) {
        this.id = id;
        this.moveSpot = move;
        this.player = player;
        this.message = message;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public int getPlayer() { return player; }

    @JsonProperty
    public int getMoveSpot() {
        return moveSpot;
    }

    @JsonProperty
    public String getMessage() { return message; }
}
