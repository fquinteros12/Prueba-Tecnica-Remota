package com.pruebatecnica.dropwizard;

import com.codahale.metrics.health.HealthCheck;
import com.pruebatecnica.dropwizard.persistence.MovieDB;

public class RestStubCheck extends HealthCheck {
    private final String version;

    public RestStubCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        if (MovieDB.getCount() == 0) {
            return Result.unhealthy("No hay peliculas en DB! Version: " + this.version);
        }
        return Result.healthy("OK, version: " + this.version + ". Movies count: " + MovieDB.getCount());
    }
}
