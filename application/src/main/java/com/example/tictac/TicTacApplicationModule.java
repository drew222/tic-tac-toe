package com.example.tictac;
import dagger.Module;
import dagger.Provides;
import java.util.ArrayList;
import javax.inject.Singleton;
import io.dropwizard.setup.Environment;
import com.codahale.metrics.MetricRegistry;

/**
 * Created by drewzoellner on 2/23/16.
 */

@Module
class TicTacApplicationModule {
    private final int boardSize;
    private final MetricRegistry metricRegistry;

    TicTacApplicationModule(TicTacConfiguration config, Environment environment){
        this.boardSize = config.getBoardSize();
        this.metricRegistry = environment.metrics();
    }

    @Singleton
    @Provides
    int provideBoardSize(){
        return boardSize;
    }

    @Singleton
    @Provides
    ArrayList<ArrayList<Integer>> provideBoards(){
        ArrayList<ArrayList<Integer>> boards = new ArrayList<>();
        return boards;
    }

    @Singleton
    @Provides
    MetricRegistry provideMetricRegistry(){
        return metricRegistry;
    }



}
