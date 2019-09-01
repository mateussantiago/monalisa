package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

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

    @NotBlank
    @Column(name = "usuario_autor")
    private Long usuarioAutor;

    @NotBlank
    @Column(name = "curtidas_positivas")
    private Long curtidasPositivas;

    @NotBlank
    @Column(name = "curtidas_negativas")
    private Long curtidasNegativas;

    @Column(name = "id_postagem_genitora")
    private Postagem postagemGenitora;

    @OneToMany(mappedBy = "postagemGenitora", cascade = CascadeType.ALL)
    private Set<Postagem> postagensFilhas;

//    @OneToMany(mappedBy = "postagem", cascade = CascadeType.ALL)
//    private

    public Long getIdPostagem(){  return idPostagem;  }

    public void setIdPostagem(Long idPostagem) { this.idPostagem = idPostagem;  }

    public String getTexto(){ return texto; }

    public void setTexto(String texto) { this.texto = texto; }

    public Long getCurtidasPositivas() { return curtidasPositivas; }

    public void setCurtidasPositivas(Long curtidasPositivas) { this.curtidasPositivas = curtidasPositivas; }

    public Long getCurtidasNegativas() {
        return curtidasNegativas;
    }

    public void setCurtidasNegativas(Long curtidasNegativas) {
        this.curtidasNegativas = curtidasNegativas;
    }

    public Long getUsuarioAutor() { return usuarioAutor; }

    public void setUsuarioAutor(Long usuarioAutor) { this.usuarioAutor = usuarioAutor; }

    public Postagem getPostagemGenitora() {
        return postagemGenitora;
    }

    public void setPostagemGenitora(Postagem postagemGenitora) {
        this.postagemGenitora = postagemGenitora;
    }

    public Set<Postagem> getPostagensFilhas() {
        return postagensFilhas;
    }

    public void setPostagensFilhas(Set<Postagem> postagensFilhas) {
        this.postagensFilhas = postagensFilhas;
    }
}
