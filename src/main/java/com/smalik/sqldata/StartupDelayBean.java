package com.smalik.sqldata;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Log
@Configuration
public class StartupDelayBean {

    public StartupDelayBean(@Value("${startup.delay-seconds:0}") int startupDelaySeconds) throws InterruptedException {
        if (startupDelaySeconds > 0) {
            log.info(String.format("Going to delay startup for %d seconds", startupDelaySeconds));
            Thread.sleep(startupDelaySeconds * 1000l);
        }
    }
}
