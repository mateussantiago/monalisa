package br.com.monalisa.dto;

import br.com.monalisa.model.Postagem;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostagemDTO {
    @NotBlank
    private String texto;

    private Long postagemGenitora;

    @NotNull
    private Long turma;

    @NotNull
    private Long assunto;

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

    public Long getTurma() {
        return turma;
    }

    public void setTurma(Long turma) {
        this.turma = turma;
    }

    public Long getAssunto() {
        return assunto;
    }

    public void setAssunto(Long assunto) {
        this.assunto = assunto;
    }
}
