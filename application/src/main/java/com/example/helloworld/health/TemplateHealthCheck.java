package com.example.helloworld.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final int boardSize;

    public TemplateHealthCheck(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    protected Result check() throws Exception {
        if (boardSize != 9) {
            return Result.unhealthy("The board size is not the correct size for Tic-Tac-Toe");
        }
        return Result.healthy();
    }
}
