package br.com.monalisa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SugestaoAssuntoDTO {
    @NotBlank
    private String nome_assunto;

    @NotBlank
    private String justificativa_sugestao;

    private String descricao_assunto;

    private Long idTurma;

    public String getNome_assunto() {
        return nome_assunto;
    }

    public String getJustificativa_sugestao() {
        return justificativa_sugestao;
    }

    public String getDescricao_assunto() {
        return descricao_assunto;
    }

    public Long getIdTurma() {
        return idTurma;
    }
}
