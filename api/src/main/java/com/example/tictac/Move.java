package com.example.tictac;

/**
 * Created by drewzoellner on 2/18/16.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import static com.google.common.base.Preconditions.checkNotNull;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Move move = (Move) o;
        return Objects.equals(id, move.id)
                && Objects.equals(player, move.player)
                && Objects.equals(moveSpot, move.moveSpot)
                && Objects.equals(message, move.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player, moveSpot, message);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("player", player)
                .add("moveSpot", moveSpot)
                .add("message", message)
                .toString();
    }
}
