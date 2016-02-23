package com.example.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.health.TemplateHealthCheck;


import java.util.ArrayList;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    ArrayList<Integer> board;
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        // nothing to do yet
        board = new ArrayList<Integer>();
	    final HelloWorldResource resource = new HelloWorldResource(board, configuration.getBoardSize());
        final TicTacResource resource2 = new TicTacResource(board);
	    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(Integer.parseInt(configuration.getBoardSize()));
	    environment.jersey().register(resource);
        environment.jersey().register(resource2);
	    environment.healthChecks().register("boardSize", healthCheck);
    }

}
