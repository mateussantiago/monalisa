package br.com.monalisa.exception;

public class UsuarioComCampoNaoInformadoException extends Exception {

    public UsuarioComCampoNaoInformadoException() { }

    public UsuarioComCampoNaoInformadoException(String mensagem) {
        super(mensagem);
    }

}
