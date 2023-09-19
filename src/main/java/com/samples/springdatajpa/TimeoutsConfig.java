package com.samples.springdatajpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@ConfigurationProperties("timeouts")
public class TimeoutsConfig {

    private int readTimeout;
    private int connectionTimeout;
}
