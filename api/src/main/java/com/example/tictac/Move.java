package com.example.tictac;

/**
 * Created by drewzoellner on 2/18/16.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
//import org.hibernate.validator.constraints.Length;

public class Move {
    private final long id;
    private final int player;
    private final int moveSpot;
    private final String message;

    public Move() {
        // Jackson deserialization
        this.id = -1;
        this.player = -1;
        this.moveSpot = -1;
        this.message = "";
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
