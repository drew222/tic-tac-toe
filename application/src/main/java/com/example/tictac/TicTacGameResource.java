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
    private ArrayList<ArrayList<Integer>> boards;
    private ArrayList<Integer> gameOvers = new ArrayList<>();
    private ArrayList<Integer> onesTurns = new ArrayList<>();
    private int boardSize;

    @Inject
    public TicTacGameResource(ArrayList<ArrayList<Integer>> boards, int boardSize) {
        this.counter = new AtomicLong();
        this.boards = boards;
        this.boardSize = boardSize;
    }

    @POST
    @Path("/create")
    public Game createGame(){
        int id = boards.size();
        ArrayList<Integer> newGame = new ArrayList<>();
        for(int i = 0; i < boardSize; i++){
            newGame.add(0);
        }
        this.boards.add(newGame);
        this.gameOvers.add(0);
        this.onesTurns.add(1);
        return new Game(id);
    }

    @POST
    @Path("/move")
    @Timed
    public Move performMove(@QueryParam("game") int game, @QueryParam("player") int player, @QueryParam("move") int move){
        if (game >= this.boards.size() || game < 0){
            return new Move(counter.incrementAndGet(), player, move, "This game does not exist.");
        }
        if (gameOvers.get(game) == 1){
            return new Move(counter.incrementAndGet(), player, move, "Game is Over!");
        }
        if ((player != 1 && player != 2) || (move > 9 || move < 1) || (boards.get(game).get(move - 1) != 0)
                || ((onesTurns.get(game) == 1) && player == 2) || ((onesTurns.get(game) == 0) && player == 1)){
            //invalid move
            return new Move(counter.incrementAndGet(), move, player, "Invalid Instruction.");
        }else {
            //good move, update board
            boards.get(game).set(move - 1, player);
            if (onesTurns.get(game) == 1) {
                onesTurns.set(game, 0);
            }else{
                onesTurns.set(game, 1);
            }
            //check if the move makes a player win
            if (foundWinner(boards.get(game))) {
                gameOvers.set(game, 1);
                return new Move(counter.incrementAndGet(), move, player, "Player " + player + " wins!");
            }else {
                return new Move(counter.incrementAndGet(), move, player, boardString(boards.get(game)));
            }
        }
    }

    @GET
    @Timed
    public Move retrieveBoard(@QueryParam("game") int game){
        if (game >= this.boards.size() || game < 0){
            return new Move(counter.incrementAndGet(), -1, -1, "This game does not exist.");
        }
        return new Move(-1, -1, -1, boards.get(game).toString());
    }

    public boolean foundWinner(ArrayList<Integer> board){
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
    public String boardString(ArrayList<Integer> board){
        String theString = "\n" + "| " + board.get(0) + " | " + board.get(1) + " | " + board.get(2) + " |\n";
        theString += "| " + board.get(3) + " | " + board.get(4) + " | " + board.get(5) + " |\n";
        theString += "| " + board.get(6) + " | " + board.get(7) + " | " + board.get(8) + " |";
        return theString;
    }

    //this is for testing purposes
    public ArrayList<ArrayList<Integer>> getBoards(){
        return this.boards;
    }
}
