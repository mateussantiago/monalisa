package br.com.monalisa.framework.model;


import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.model.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "postagem")
public class Postagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_postagem", allocationSize = 1)
    @Column(name = "id_postagem")
    private Long idPostagem;

    @Column(name = "ativo")
    private Boolean ativo = true;

    @NotBlank
    @Column(name = "conteudo")
    private String conteudo;

    @Column(name = "curtidas_positivas")
    private Long curtidasPositivas = 0L;

    @Column(name = "curtidas_negativas")
    private Long curtidasNegativas = 0L;

    @ManyToOne
    @JoinColumn(name = "id_postagem_genitora")
    private br.com.monalisa.model.Postagem postagemGenitora;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario_autor")
    private Usuario usuarioAutor;

    @ManyToOne
    @JoinColumn(name = "id_assunto_turma")
    private AssuntoTurma assuntoTurma;

    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Long getCurtidasPositivas() {
        return curtidasPositivas;
    }

    public void setCurtidasPositivas(Long curtidasPositivas) {
        this.curtidasPositivas = curtidasPositivas;
    }

    public Long getCurtidasNegativas() {
        return curtidasNegativas;
    }

    public void setCurtidasNegativas(Long curtidasNegativas) {
        this.curtidasNegativas = curtidasNegativas;
    }

    public br.com.monalisa.model.Postagem getPostagemGenitora() {
        return postagemGenitora;
    }

    public void setPostagemGenitora(br.com.monalisa.model.Postagem postagemGenitora) {
        this.postagemGenitora = postagemGenitora;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public AssuntoTurma getAssuntoTurma() {
        return assuntoTurma;
    }

    public void setAssuntoTurma(AssuntoTurma assuntoTurma) {
        this.assuntoTurma = assuntoTurma;
    }
}
