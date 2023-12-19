package com.example.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyCustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // this is where you put some logic, to decide if sth is down or up and incude it
        // in health endpoints.
        return Health.up()
                .withDetail("abc","bcd")
                .build();
    }
}
/**
 * Add new health info -> add custom component
 */
