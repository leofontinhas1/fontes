package com.br.fontinhas.fontes.controller.handler;

import com.br.fontinhas.fontes.exeption.LocalizedException;
import com.br.fontinhas.fontes.i18n.Internationalization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @Autowired
    private Internationalization i18n;

    @ExceptionHandler(LocalizedException.class)
    public ResponseEntity localizedExceptionHandler(LocalizedException localizedException){
        return ResponseEntity.status(localizedException.getStatus()).body(i18n.getLocalizedMessage(localizedException.getMessage()));
    }

}
