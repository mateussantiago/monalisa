package br.com.monalisa.exception;

import java.util.IllegalFormatException;

public class PostagemSemConteudoException extends RuntimeException {
    public PostagemSemConteudoException() {

    }

    public PostagemSemConteudoException(String message) {
        super(message);
    }
}
