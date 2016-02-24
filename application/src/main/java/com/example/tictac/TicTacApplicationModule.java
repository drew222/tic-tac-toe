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
        ArrayList<Integer> board = new ArrayList<>();
        for(int i = 0; i < boardSize; i++){
            board.add(0);
        }
        return board;
    }



}
