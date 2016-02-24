package com.example.tictac;

/**
 * Created by drewzoellner on 2/22/16.
 */

import retrofit.RestAdapter;

public class TicTacClient {
    private final RestAdapter adapter;

    public TicTacClient(String urlString){
        adapter = new RestAdapter.Builder()
                .setEndpoint(urlString)
                .build();
    }

    public TicTacWriteClient newTicTacWriteClient() {
        return adapter.create(TicTacWriteClient.class);
    }

    public TicTacReadClient newTicTacReadClient() { return adapter.create(TicTacReadClient.class); }

}
