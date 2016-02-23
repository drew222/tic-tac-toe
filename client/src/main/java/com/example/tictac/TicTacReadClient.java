package com.example.tictac;
import retrofit.http.GET;
/**
 * Created by drewzoellner on 2/23/16.
 */
public interface TicTacReadClient {

    @GET("/tictac")
    Move retrieveBoard();

}
