package com.example.tictac;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.tictac.health.TemplateHealthCheck;
import dagger.*;

import java.util.ArrayList;

public class TicTacApplication extends Application<TicTacConfiguration> {
    ArrayList<Integer> board = new ArrayList<Integer>();
    public static void main(String[] args) throws Exception {
        new TicTacApplication().run(args);
    }

    @Override
    public String getName() {
        return "tictac";
    }

    @Override
    public void initialize(Bootstrap<TicTacConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TicTacConfiguration configuration,
                    Environment environment) {
        /*
	    final TicTacGameResource resource = new TicTacGameResource(board, configuration.getBoardSize());
        final TicTacResource resource2 = new TicTacResource(board);
	    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getBoardSize());
	    environment.jersey().register(resource);
        environment.jersey().register(resource2);
	    environment.healthChecks().register("boardSize", healthCheck);
	    */



        TicTacApplicationComponent component = DaggerTicTacApplicationComponent.builder()
                .ticTacApplicationModule(new TicTacApplicationModule(configuration))
                .build();

        environment.healthChecks().register("boardSize", component.getTemplateHealthCheck());
        environment.jersey().register(component.getTicTacGameResource());
        environment.jersey().register(component.getTicTacResource());


    }

}
