package com.smalik.sqldata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timeouts")
public class TimeoutsController {

    private final TimeoutsConfig timeoutsConfig;

    @GetMapping
    public TimeoutsConfig getTimeoutsConfig() {
        return timeoutsConfig;
    }
}
