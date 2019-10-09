package br.com.monalisa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostagemDTO {
    @NotBlank
    private String texto;

    private Long postagemGenitora;

    @NotNull
    private Long assuntoTurma;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getPostagemGenitora() {
        return postagemGenitora;
    }

    public void setPostagemGenitora(Long postagemGenitora) {
        this.postagemGenitora = postagemGenitora;
    }

    public Long getAssuntoTurma() {
        return assuntoTurma;
    }

    public void setAssuntoTurma(Long assuntoTurma) {
        this.assuntoTurma = assuntoTurma;
    }
}
