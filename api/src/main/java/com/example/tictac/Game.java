package com.example.tictac;
import com.fasterxml.jackson.annotation.JsonProperty;
import static com.google.common.base.Preconditions.checkNotNull;
import com.fasterxml.jackson.annotation.JsonCreator;
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
    public String toString(){
        return "" + this.id;
    }

    @Override
    public boolean equals(Object thing){
        if (thing.getClass() != Game.class){
            return false;
        }
        Game aThing = (Game) thing;
        if (aThing.getId() != this.id){
            return false;
        }
        return true;
    }

}
