package com.example.tictac;

import org.junit.Test;

import java.util.*;

public class ApplicationTest {

    @Test
    public void testBoardCreation() {
        TicTacGameResource aResource = new TicTacGameResource(new ArrayList<Integer>(), "9");
        assert(aResource.board.size() == 9);
    }

    @Test
    public void testBoardMove(){
        TicTacGameResource aResource = new TicTacGameResource(new ArrayList<Integer>(), "9");
        aResource.performMove(1,1);
        assert(aResource.board.get(0) == 1);
        assert(aResource.board.get(1) == 0);
    }

}