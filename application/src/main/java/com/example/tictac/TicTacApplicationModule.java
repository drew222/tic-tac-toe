package com.example.tictac;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import javax.inject.Singleton;

/**
 * Created by drewzoellner on 2/23/16.
 */

@Module
class TicTacApplicationModule {
    private final int boardSize;

    TicTacApplicationModule(TicTacConfiguration config){
        this.boardSize = config.getBoardSize();
    }

    @Singleton
    @Provides
    int provideBoardSize(){
        return boardSize;
    }

    @Singleton
    @Provides
    ArrayList<Integer> provideBoard(){
        return new ArrayList<Integer>();
    }



}
