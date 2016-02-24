package com.example.tictac;


import retrofit.http.*;


public interface TicTacWriteClient {

    @POST("/tictac/move")
    Move performMove(@Query("game") int game, @Query("player") int player, @Query("move") int move);

    @POST("/tictac/create")
    Game createGame();
}
