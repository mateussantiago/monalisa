package br.com.monalisa.dto;

public class DenunciaDTO {

    public Long idPostagem;

    public Long idUsuarioDenunciador;

    public String motivacao;

    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(String motivacao) {
        this.motivacao = motivacao;
    }
}
