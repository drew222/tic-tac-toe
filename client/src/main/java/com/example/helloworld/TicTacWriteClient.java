package com.example.helloworld;


import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;


public interface TicTacWriteClient {

    @POST("/hello-world/posts")
    Move performMove(int player, int move);
}
