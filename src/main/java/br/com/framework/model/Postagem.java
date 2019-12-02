package br.com.framework.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @Column(name = "texto")
    private String texto;

    @Column(name = "curtidas_positivas")
    private Long curtidasPositivas = 0L;

    @Column(name = "curtidas_negativas")
    private Long curtidasNegativas = 0L;

    @ManyToOne
    @JoinColumn(name = "id_postagem_genitora")
    private Postagem postagemGenitora;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario_autor")
    private Usuario usuarioAutor;

    @OneToOne
    @JoinColumn(name = "id_topico")
    private Topico topico;

    @OneToMany(mappedBy = "postagemGenitora")
    private List<Postagem> respostas;

    @JsonIgnore
    @OneToMany(mappedBy = "postagem")
    private List<Denuncia> denuncias;

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

    public Postagem getPostagemGenitora() {
        return postagemGenitora;
    }

    public void setPostagemGenitora(Postagem postagemGenitora) {
        this.postagemGenitora = postagemGenitora;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public List<Postagem> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Postagem> respostas) {
        this.respostas = respostas;
    }

    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }
}
