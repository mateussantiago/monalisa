package br.com.monalisa.framework.model;

import javax.persistence.*;

public class ConteudoTopico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_conteudo_topico", allocationSize = 1)
    @Column(name = "id_conteudo_topico")
    private Long idConteudoTopico;

    @ManyToOne
    @JoinColumn(name = "id_conteudo")
    private Topico topico;

    @ManyToOne
    @JoinColumn(name = "id_topico")
    private Conteudo conteudo;

    @Column(name = "ativo")
    private boolean ativo = true;

    public Long getIdConteudoTopico() {
        return idConteudoTopico;
    }

    public void setIdConteudoTopico(Long idConteudoTopico) {
        this.idConteudoTopico = idConteudoTopico;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
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
