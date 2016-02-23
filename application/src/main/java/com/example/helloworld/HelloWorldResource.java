package com.example.helloworld;

//import com.example.helloworld.Move;
import com.codahale.metrics.annotation.Timed;
import java.util.ArrayList;

import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final AtomicLong counter;
    ArrayList<Integer> board;
    private boolean gameOver = false;
    private boolean onesTurn = true;

    public HelloWorldResource(ArrayList<Integer> board, String boardSize) {
        this.counter = new AtomicLong();
        this.board = board;
        for(int i = 0; i < Integer.parseInt(boardSize); i++){
            board.add(0);
        }
    }

    /*
    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.or(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
    */

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
