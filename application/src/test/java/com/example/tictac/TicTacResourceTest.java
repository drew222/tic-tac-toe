package com.example.tictac;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TicTacResourceTest {

    @Test
    public void testBoardMove() {
        ArrayList<ArrayList<Integer>> someBoards = new ArrayList<>();
        TicTacGameResource aResource = new TicTacGameResource(someBoards, 9);
        Game aGame = aResource.createGame();
        Move theMove = aResource.performMove(aGame.getId(), 1, 1);
        assertTrue(theMove.getMoveSpot() == 1);
    }

    @Test
    public void testBoardGet(){
        ArrayList<ArrayList<Integer>> someBoards = new ArrayList<>();
        TicTacGameResource aResource = new TicTacGameResource(someBoards, 9);
        Game aGame = aResource.createGame();
        aResource.performMove(aGame.getId(), 1, 1);
        ArrayList<ArrayList<Integer>> theBoards = aResource.getBoards();
        assertTrue(theBoards.get(aGame.getId()).get(0) == 1);
        assertTrue(theBoards.get(aGame.getId()).get(1) == 0);
    }

}