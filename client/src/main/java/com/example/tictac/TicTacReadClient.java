package com.example.tictac;
import retrofit.http.*;
/**
 * Created by drewzoellner on 2/23/16.
 */
public interface TicTacReadClient {

    @GET("/tictac")
    Move retrieveBoard(@Query("game") int game);

}
