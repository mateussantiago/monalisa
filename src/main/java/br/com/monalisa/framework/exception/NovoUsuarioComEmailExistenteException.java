package br.com.monalisa.framework.exception;

public class NovoUsuarioComEmailExistenteException extends Exception {

    public NovoUsuarioComEmailExistenteException() {

    }

    public NovoUsuarioComEmailExistenteException(String message) {
        super(message);
    }
}
