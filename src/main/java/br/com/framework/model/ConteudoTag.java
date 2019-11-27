package br.com.framework.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "conteudo_tag")
public class ConteudoTag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_conteudo_tag", allocationSize = 1)
    @Column(name = "id_conteudo_tag")
    private Long idConteudoTag;

    @ManyToOne
    @JoinColumn(name = "id_tag")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "id_conteudo")
    private Conteudo conteudo;

    @Column(name = "ativo")
    private boolean ativo = true;

    public Long getIdConteudoTag() {
        return idConteudoTag;
    }

    public void setIdConteudoTag(Long idConteudoTag) {
        this.idConteudoTag = idConteudoTag;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
