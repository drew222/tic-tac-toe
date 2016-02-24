package com.example.tictac;

import com.codahale.metrics.annotation.Timed;
import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;

@Path("/tictac")
@Produces(MediaType.APPLICATION_JSON)
public class TicTacGameResource {
    private final AtomicLong counter;
    ArrayList<Integer> board;
    private boolean gameOver = false;
    private boolean onesTurn = true;

    @Inject
    public TicTacGameResource(ArrayList<Integer> board) {
        this.counter = new AtomicLong();
        this.board = board;
    }

    @POST
    @Timed
    public Move performMove(@QueryParam("player") int player, @QueryParam("move") int move){
        if (gameOver){
            return new Move(counter.incrementAndGet(), player, move, "Game is Over!");
        }
        if ((player != 1 && player != 2) || (move > 9 || move < 1) || (board.get(move - 1) != 0)
                || (onesTurn && player == 2) || (!onesTurn && player == 1)){
            //invalid move
            return new Move(counter.incrementAndGet(), move, player, "Invalid Instruction.");
        }else {
            //good move, update board
            board.set(move - 1, player);
            onesTurn = !onesTurn;
            //check if the move makes a player win
            if (foundWinner()) {
                gameOver = true;
                return new Move(counter.incrementAndGet(), move, player, "Player " + player + " wins!");
            }else {
                return new Move(counter.incrementAndGet(), move, player, boardString());
            }
        }
    }

    @GET
    @Timed
    public Move retrieveBoard(){
        return new Move(-1, -1, -1, board.toString());
    }

    public boolean foundWinner(){
        //check columns
        if (board.get(0) != 0 && (board.get(0) == board.get(3) && board.get(3) == board.get(6))){
            return true;
        }else if (board.get(1) != 0 && (board.get(1) == board.get(4) && board.get(4) == board.get(7))){
            return true;
        }else if (board.get(2) != 0 && (board.get(2) == board.get(5) && board.get(5) == board.get(8))){
            return true;
        }
        //check rows
        else if (board.get(0) != 0 && (board.get(0) == board.get(1) && board.get(1) == board.get(2))){
            return true;
        }else if (board.get(3) != 0 && (board.get(3) == board.get(4) && board.get(4) == board.get(5))){
            return true;
        }else if (board.get(6) != 0 && (board.get(6) == board.get(7) && board.get(7) == board.get(8))){
            return true;
        }
        //check diagnals
        else if (board.get(0) != 0 && (board.get(0) == board.get(4) && board.get(4) == board.get(8))){
            return true;
        }else if (board.get(2) != 0 && (board.get(2) == board.get(4) && board.get(4) == board.get(6))){
            return true;
        }else{
            return false;
        }
    }

    //not printing as intended in a JSON format
    public String boardString(){
        String theString = "\n" + "| " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " |\n";
        theString += "| " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " |\n";
        theString += "| " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " |";
        return theString;
    }
}
