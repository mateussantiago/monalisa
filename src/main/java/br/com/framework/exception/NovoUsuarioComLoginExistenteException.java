package br.com.framework.exception;

public class NovoUsuarioComLoginExistenteException extends Exception {

    public NovoUsuarioComLoginExistenteException() {

    }

    public NovoUsuarioComLoginExistenteException(String message) {
        super(message);
    }
}
