package com.example.tictac;


import retrofit.http.*;
//import javax.ws.rs.*;


public interface TicTacWriteClient {

    @POST("/tictac")
    Move performMove(@Query("player") int player, @Query("move") int move);
}
