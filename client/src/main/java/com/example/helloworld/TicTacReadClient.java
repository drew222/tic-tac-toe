package com.example.helloworld;
import retrofit.http.GET;
/**
 * Created by drewzoellner on 2/23/16.
 */
public interface TicTacReadClient {

    @GET("/hello-world")
    Move retrieveBoard();

}
