package com.example.subscriptionapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping("/status")
    private HashMap<String, Object> getApiStatus() {
        var response = new HashMap<String, Object>();

        response.put("service", "Subscription-API");
        response.put("httpStatus", HttpStatus.OK.value());
        response.put("status", "UP");

        return response;
    }

}
