package br.com.monalisa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OperacaoInvalidaException extends RuntimeException {
    public OperacaoInvalidaException() {
    }

    public OperacaoInvalidaException(String message) {
        super(message);
    }
}
