package com.example.tictac;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;

public class TicTacApplication extends Application<TicTacConfiguration> {
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
        TicTacApplicationComponent component = DaggerTicTacApplicationComponent.builder()
                .ticTacApplicationModule(new TicTacApplicationModule(configuration))
                .build();

        environment.healthChecks().register("boardSize", component.getTemplateHealthCheck());
        environment.jersey().register(component.getTicTacGameResource());
        environment.jersey().register(component.getTicTacResource());
    }

}
