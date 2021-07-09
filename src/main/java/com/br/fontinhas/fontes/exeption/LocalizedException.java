package com.br.fontinhas.fontes.exeption;

import org.springframework.http.HttpStatus;

public class LocalizedException extends Throwable {

    private String message;

    private HttpStatus status;


    public LocalizedException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
