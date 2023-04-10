package com.smalik.sqldata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomServiceHealthController {

    private final CustomServiceHealthIndicator indicator;
    
    @PostMapping("/up")
    public void markItUp() {
        indicator.setCustomServiceUp(true);
    }

    @PostMapping("/down")
    public void markItDown() {
        indicator.setCustomServiceUp(false);
    }
}
