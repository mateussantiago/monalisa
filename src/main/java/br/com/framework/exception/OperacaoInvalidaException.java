package br.com.framework.exception;

public class OperacaoInvalidaException extends RuntimeException {
    public OperacaoInvalidaException() {
    }

    public OperacaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
