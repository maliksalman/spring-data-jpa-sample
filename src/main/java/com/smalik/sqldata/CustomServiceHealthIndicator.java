package com.smalik.sqldata;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomServiceHealthIndicator implements HealthIndicator {

    private String message_key = "custom-health";
    private boolean customServiceUp;

    @Override
    public Health health() {
        if (!isCustomServiceUp()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }

        return Health.up().withDetail(message_key, "Available").build();
    }

    public boolean isCustomServiceUp() {
        return customServiceUp;
    }

    public void setCustomServiceUp(boolean customServiceUp) {
        this.customServiceUp = customServiceUp;
    }
}