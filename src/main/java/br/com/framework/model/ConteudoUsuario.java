package br.com.framework.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "conteudo_usuario")
public class ConteudoUsuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_conteudo_usuario", allocationSize = 1)
    @Column(name = "id_conteudo_usuario")
    private Long idConteudoUsuario;

    @ManyToOne
    @JoinColumn(name = "id_conteudo")
    private Conteudo conteudo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "ativo")
    private Boolean ativo = true;

    public Long getIdConteudoUsuario() {
        return idConteudoUsuario;
    }

    public void setIdConteudoUsuario(Long idConteudoUsuario) {
        this.idConteudoUsuario = idConteudoUsuario;
    }

    public Conteudo getConteudo() {
        return conteudo;
    }

    public void setConteudo(Conteudo conteudo) {
        this.conteudo = conteudo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
