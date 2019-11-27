package br.com.framework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RetornoDeBuscaVazioException extends EntityNotFoundException {
    public RetornoDeBuscaVazioException() {
    }

    public RetornoDeBuscaVazioException(String message) {
        super(message);
    }
}