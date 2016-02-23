package com.example.tictac;

/**
 * Created by drewzoellner on 2/18/16.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import static com.google.common.base.Preconditions.checkNotNull;
//import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Move {
    private final long id;
    private final int player;
    private final int moveSpot;
    private final String message;

    
    @JsonCreator
    public Move(@JsonProperty("id") long id, @JsonProperty("move") int move,
                @JsonProperty("player") int player, @JsonProperty("message") String message) {
        checkNotNull(id);
        checkNotNull(move);
        checkNotNull(player);
        checkNotNull(message);

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
