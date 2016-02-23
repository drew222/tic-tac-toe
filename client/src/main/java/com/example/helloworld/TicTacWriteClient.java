package com.example.helloworld;


import retrofit.http.*;

import javax.ws.rs.QueryParam;
//import javax.ws.rs.*;


public interface TicTacWriteClient {

    @POST("/hello-world")
    Move performMove(@Query("player") int player, @Query("move") int move);
}
