package com.example.subscriptionapi.sub.config.exception;

import lombok.Data;

@Data // <- Vai gerar os getters and setters
public class ExceptionDetails {

    private int status;
    private String message;

}
