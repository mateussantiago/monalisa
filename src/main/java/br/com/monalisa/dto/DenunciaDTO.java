package br.com.monalisa.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DenunciaDTO {
    @NotNull
    public Long idPostagem;

    @NotBlank
    public String motivacao;

    public Long getIdPostagem() {
        return idPostagem;
    }

    public String getMotivacao() {
        return motivacao;
    }
}
