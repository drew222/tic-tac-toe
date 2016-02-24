package com.example.tictac;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TicTacResourceTest {

    @Test
    public void testBoardCreation() {
        ArrayList<Integer> aBoard = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            aBoard.add(0);
        }
        TicTacGameResource aResource = new TicTacGameResource(aBoard);
        assertTrue(aResource.board.size() == 9);
    }

    @Test
    public void testBoardMove(){
        ArrayList<Integer> aBoard = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            aBoard.add(0);
        }
        TicTacGameResource aResource = new TicTacGameResource(aBoard);
        aResource.performMove(1,1);
        assertTrue(aResource.board.get(0) == 1);
        assertTrue(aResource.board.get(1) == 0);
    }

}