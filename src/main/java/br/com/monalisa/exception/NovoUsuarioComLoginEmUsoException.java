package br.com.monalisa.exception;

public class NovoUsuarioComLoginEmUsoException extends Exception {
    public NovoUsuarioComLoginEmUsoException() {

    }

    public NovoUsuarioComLoginEmUsoException(String message) {
        super(message);
    }
}
