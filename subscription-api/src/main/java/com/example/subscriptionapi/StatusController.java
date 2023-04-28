package com.example.subscriptionapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class StatusController {

    @GetMapping("/status") //Busca por "api/status"; Se existir, o método é executado
    private HashMap<String, Object> getApiStatus() {
        var response = new HashMap<String, Object>();

        response.put("service", "Subscription-API");
        response.put("httpStatus", HttpStatus.OK.value());
        response.put("status", "UP");

        return response;
    }

/*
    @GetMapping("/status") //Busca por "api/status"; Se existir, o método é executado
    public ResponseEntity<HashMap<String, Object>> getApiStatus() {
        var response = new HashMap<String, Object>();

        response.put("service", "Subscription-API");
        response.put("status", "UP");
        response.put("httpStatus", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }
*/
}
