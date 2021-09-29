package com.sigabem.calculofrete.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class CepNaoEncontradoException extends HttpStatusCodeException {
    public CepNaoEncontradoException(HttpStatus statusCode, String statusText) {
        super(statusCode, statusText);
    }



}

