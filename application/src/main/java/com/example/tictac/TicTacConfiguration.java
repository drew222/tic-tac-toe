package com.example.tictac;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import javax.inject.Inject;


public class TicTacConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty("boardSize")
    private String boardSize;

    //@JsonProperty
    //@Inject
    public int getBoardSize() { return Integer.parseInt(this.boardSize); }

   // @JsonProperty
    public void setBoardSize(String boardSize) { this.boardSize = boardSize; }
}
