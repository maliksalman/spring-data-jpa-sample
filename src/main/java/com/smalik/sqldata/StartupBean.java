package com.smalik.sqldata;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Log
@Configuration
public class StartupBean {

    public StartupBean(@Value("${delays.startup:0}") int startupDelaySeconds,
                       @Value("${delays.up-status:0}") int markItUpDelaySeconds,
                       CustomServiceHealthIndicator indicator) throws InterruptedException {

        if (startupDelaySeconds > 0) {
            log.info(String.format("Going to delay startup for %d seconds", startupDelaySeconds));
            Thread.sleep(startupDelaySeconds * 1000l);
        }

        markItUp(indicator, markItUpDelaySeconds);
    }

    public void markItUp(CustomServiceHealthIndicator indicator, int markItUpDelaySeconds) {
        log.info(String.format("Will mark the custom service UP in %d seconds", markItUpDelaySeconds));
        new Thread(() -> {
            try {
                Thread.sleep(markItUpDelaySeconds * 1000l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("Marking the custom service UP");
            indicator.setCustomServiceUp(true);
        }).start();
    }
}
