package br.com.framework.exception;

public class PostagemSemConteudoException extends RuntimeException {
    public PostagemSemConteudoException() {
    }

    public PostagemSemConteudoException(String mensagem) {
        super(mensagem);
    }
}
