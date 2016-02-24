package com.example.tictac;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class TicTacResourceTest {
    MetricRegistry registry = new MetricRegistry();
    final Timer createTimer = registry.timer("creation-timer");
    final Timer moveTimer = registry.timer("move-timer");
    @Test
    public void testBoardMove() {
        ArrayList<ArrayList<Integer>> someBoards = new ArrayList<>();
        TicTacGameResource aResource = new TicTacGameResource(someBoards, 9, new MetricRegistry());
        final Timer.Context context = createTimer.time();
        Game aGame;
        try {
            aGame = aResource.createGame();
        } finally{
            context.stop();
        }
        Move theMove = aResource.performMove(aGame.getId(), 1, 1);
        assertTrue(theMove.getMoveSpot() == 1);
    }

    @Test
    public void testBoardGet(){
        ArrayList<ArrayList<Integer>> someBoards = new ArrayList<>();
        TicTacGameResource aResource = new TicTacGameResource(someBoards, 9, new MetricRegistry());
        Game aGame = aResource.createGame();
        final Timer.Context context = moveTimer.time();
        try {
            aResource.performMove(aGame.getId(), 1, 1);
        } finally{
            context.stop();
        }
        ArrayList<ArrayList<Integer>> theBoards = aResource.getBoards();
        assertTrue(theBoards.get(aGame.getId()).get(0) == 1);
        assertTrue(theBoards.get(aGame.getId()).get(1) == 0);
    }

}