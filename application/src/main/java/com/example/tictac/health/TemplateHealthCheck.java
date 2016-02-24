package com.example.tictac.health;

import com.codahale.metrics.health.HealthCheck;
import javax.inject.Inject;
import java.util.ArrayList;
public class TemplateHealthCheck extends HealthCheck {
    private final int boardSize;
    private final ArrayList<ArrayList<Integer>> boards;

    @Inject
    public TemplateHealthCheck(int boardSize, ArrayList<ArrayList<Integer>> boards) {
        this.boards = boards;
        this.boardSize = boardSize;
    }

    @Override
    protected Result check() throws Exception {
        if (boards != null){
            return Result.unhealthy("The Board is not created correctly.");
        }

        if (boardSize != 9) {
            return Result.unhealthy("The board size is not the correct size for Tic-Tac-Toe");
        }
        return Result.healthy();
    }
}
