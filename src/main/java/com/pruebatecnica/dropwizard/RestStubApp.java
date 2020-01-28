package com.pruebatecnica.dropwizard;

import com.pruebatecnica.dropwizard.resources.MovieService;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RestStubApp extends Application<RestStubConfig> {

    public static void main(String[] args) throws Exception {
        new RestStubApp().run(args);
    }

    @Override
    public void run(RestStubConfig config, Environment env) {        
        final MovieService movieService = new MovieService();
        env.jersey().register(movieService);
        
        
        env.healthChecks().register("template", new RestStubCheck(config.getVersion()));
    }

    @Override
    public void initialize(Bootstrap<RestStubConfig> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
            bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
    }
}