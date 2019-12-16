package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

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
    private Postagem postagemGenitora;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario_autor")
    private User usuarioAutor;

    @ManyToOne
    @JoinColumn(name = "id_assunto_turma")
    private AssuntoTurma assuntoTurma;

    @OneToMany(mappedBy = "postagemGenitora")
    private List<Postagem> respostas;

    public Long getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Long idPostagem) {
        this.idPostagem = idPostagem;
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

    public User getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(User usuarioAutor) {
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

    public List<Postagem> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Postagem> respostas) {
        this.respostas = respostas;
    }
}
