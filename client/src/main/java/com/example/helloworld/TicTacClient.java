package com.example.helloworld;

/**
 * Created by drewzoellner on 2/22/16.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

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

    public TicTacReadClient newTicTacReadClient() {
        return adapter.create(TicTacReadClient.class);
    }

}
