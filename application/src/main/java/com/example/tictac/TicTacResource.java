package com.example.tictac;

/**
 * Created by drewzoellner on 2/23/16.
 */

import com.codahale.metrics.annotation.Timed;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tictac")
@Produces(MediaType.APPLICATION_JSON)
public class TicTacResource {
    ArrayList<Integer> board;
    public TicTacResource(ArrayList<Integer> board){
        this.board = board;
    }

    @GET
    @Timed
    public Move retrieveBoard(){
        return new Move(-1, -1, -1, board.toString());
    }
}
