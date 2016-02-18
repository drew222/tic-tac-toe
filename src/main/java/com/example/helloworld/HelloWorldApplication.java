package com.example.helloworld;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.example.helloworld.resources.HelloWorldResource;
import com.example.helloworld.health.TemplateHealthCheck;
import java.util.ArrayList;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
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
	final HelloWorldResource resource = new HelloWorldResource(new ArrayList<Integer>(), configuration.getBoardSize());
	final TemplateHealthCheck healthCheck = new TemplateHealthCheck(Integer.parseInt(configuration.getBoardSize()));
	environment.jersey().register(resource);
	environment.healthChecks().register("boardSize", healthCheck);
    }

}
