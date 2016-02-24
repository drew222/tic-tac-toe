package com.example.tictac;


import retrofit.http.*;


public interface TicTacWriteClient {

    @POST("/tictac")
    Move performMove(@Query("player") int player, @Query("move") int move);
}
