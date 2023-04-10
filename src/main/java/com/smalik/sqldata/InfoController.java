package com.smalik.sqldata;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
public class InfoController {

    private final HealthEndpoint healthEndpoint;
    private final String version;

    public InfoController(HealthEndpoint healthEndpoint, @Value("${version:UNKNOWN}") String version) {
        this.healthEndpoint = healthEndpoint;
        this.version = version;
    }

    @GetMapping("/info")
    public Info info() {
        return new Info(OffsetDateTime.now(), version, healthEndpoint.health().getStatus().getCode());
    }

    record Info(OffsetDateTime time, String version, String status) {}
}
