package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "postagem")
public class Postagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_postagem", allocationSize = 1)
    @Column(name = "id_postagem")
    private Long idPostagem;

    @NotBlank
    @Column(name = "texto")
    private String texto;

    @NotNull
    @Column(name = "usuario_autor")
    private Usuario usuarioAutor;

    @Column(name = "curtidas_positivas")
    private Long curtidasPositivas;

    @Column(name = "curtidas_negativas")
    private Long curtidasNegativas;

    @ManyToOne
    @JoinColumn(name = "id_postagem_genitora")
    private Postagem postagemGenitora;

    @ManyToOne
    @JoinColumn(name = "id_assunto_turma")
    private AssuntoTurma assuntoTurma;

    @Column(name = "ativo")
    private Boolean ativo = true;

    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public Postagem getPostagemGenitora() {
        return postagemGenitora;
    }

    public void setPostagemGenitora(Postagem postagemGenitora) {
        this.postagemGenitora = postagemGenitora;
    }

    public AssuntoTurma getAssuntoTurma() {
        return assuntoTurma;
    }

    public void setAssuntoTurma(AssuntoTurma assuntoTurma) {
        this.assuntoTurma = assuntoTurma;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
