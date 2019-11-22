package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "tag")
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_tag", allocationSize = 1)
    @Column(name = "id_tag")
    private Long idTag;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @Column(name = "ativo")
    private boolean ativo = true;

    public Long getIdTag() { return idTag; }

    public void setIdTag(Long idTag) { this.idTag = idTag; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}