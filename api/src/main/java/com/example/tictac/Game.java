package com.example.tictac;
import com.fasterxml.jackson.annotation.JsonProperty;
import static com.google.common.base.Preconditions.checkNotNull;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.google.common.base.MoreObjects;
//import com.google.common.base.Objects;
import java.util.Objects;

/**
 * Created by drewzoellner on 2/24/16.
 */
public class Game {
    private final int id;

    @JsonCreator
    public Game(@JsonProperty("id") int id){
        checkNotNull(id);

        this.id = id;
    }

    @JsonProperty
    public int getId(){ return this.id; }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
