package br.com.monalisa.dto;

public class PostagemDTO {

    private String conteudo;

    private Long idPostagemGenitora;

    private Long idAssuntoTurma;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getIdPostagemGenitora() {
        return idPostagemGenitora;
    }

    public void setIdPostagemGenitora(Long idPostagemGenitora) {
        this.idPostagemGenitora = idPostagemGenitora;
    }

    public Long getIdAssuntoTurma() {
        return idAssuntoTurma;
    }

    public void setIdAssuntoTurma(Long idAssuntoTurma) {
        this.idAssuntoTurma = idAssuntoTurma;
    }
}
