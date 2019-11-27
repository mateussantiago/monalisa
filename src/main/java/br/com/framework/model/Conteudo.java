package br.com.framework.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "public", name = "conteudo")
public class Conteudo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_conteudo", allocationSize = 1)
    @Column(name = "id_conteudo")
    private Long idConteudo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private Boolean ativo = true;

    @OneToMany(mappedBy = "conteudo")
    private List<ConteudoTopico> conteudoTopicos;

    public Long getIdConteudo() {
        return idConteudo;
    }

    public void setIdConteudo(Long idConteudo) {
        this.idConteudo = idConteudo;
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

    public List<ConteudoTopico> getConteudoTopicos() {
        return conteudoTopicos;
    }

    public void setConteudoTopicos(List<ConteudoTopico> conteudoTopicos) {
        this.conteudoTopicos = conteudoTopicos;
    }
}
