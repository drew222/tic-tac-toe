package com.example.tictac;

import org.junit.Test;

import java.util.*;

public class ApplicationTest {

    @Test
    public void testBoardCreation() {
        ArrayList<Integer> aBoard = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            aBoard.add(0);
        }
        TicTacGameResource aResource = new TicTacGameResource(aBoard);
        assert(aResource.board.size() == 9);
    }

    @Test
    public void testBoardMove(){
        ArrayList<Integer> aBoard = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            aBoard.add(0);
        }
        TicTacGameResource aResource = new TicTacGameResource(aBoard);
        aResource.performMove(1,1);
        assert(aResource.board.get(0) == 1);
        assert(aResource.board.get(1) == 0);
    }

}