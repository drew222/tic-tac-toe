package com.example.helloworld;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    @JsonProperty("boardSize")
    private String boardSize;

    //@JsonProperty
    public String getBoardSize() { return this.boardSize; }

   // @JsonProperty
    public void setBoardSize(String boardSize) { this.boardSize = boardSize; }
}
