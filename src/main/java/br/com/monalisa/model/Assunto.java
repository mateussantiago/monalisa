package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "assunto")
public class Assunto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_assunto", allocationSize = 1)
    @Column(name = "id_assunto")
    private Long idAssunto;

    @NotBlank
    @Column(name = "nome")
    private String nome;;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    public Long getIdAssunto() {
        return idAssunto;
    }

    public void setIdAssunto(Long idAssunto) {
        this.idAssunto = idAssunto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
