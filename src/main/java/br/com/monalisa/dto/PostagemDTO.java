package br.com.monalisa.dto;

public class PostagemDTO {
    private String texto;
    private Long idPostagemGenitora;
    private Long idTopico;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getIdPostagemGenitora() {
        return idPostagemGenitora;
    }

    public void setIdPostagemGenitora(Long idPostagemGenitora) {
        this.idPostagemGenitora = idPostagemGenitora;
    }

    public Long getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(Long idTopico) {
        this.idTopico = idTopico;
    }
}
