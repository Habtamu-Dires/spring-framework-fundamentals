package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private HealthEndpoint healthEndpoint;

    @GetMapping("/demo")
    public HealthComponent demo(){
        return healthEndpoint.health();
    }
}
/**
 * You can also expose some actuator data on you own end points like show
 * The above exposes the health endpoint data via /demo endpoint.
 */
