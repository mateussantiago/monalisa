package br.com.framework.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "topico")
public class Topico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_topico", allocationSize = 1)
    @Column(name = "id_topico")
    private Long idTopico;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private Boolean ativo = true;

    @OneToOne
    @JoinColumn(name = "id_conteudo")
    private Conteudo conteudo;

    public Long getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(Long idTopico) {
        this.idTopico = idTopico;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }
}
