package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "denucia")
public class Denuncia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_denuncia", allocationSize = 1)
    @Column(name = "id_denuncia")
    private Long idDenuncia;

    @NotBlank
    @Column(name = "motivacao")
    private String motivacao;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario_autor")
    private Usuario usuarioAutor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;

    @NotNull
    @Column (name = "value")
    private Boolean ativo = true;

    public Long getIdDenuncia() {
        return idDenuncia;
    }

    public void setIdDenuncia(Long idDenuncia) {
        this.idDenuncia = idDenuncia;
    }

    public String getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(String motivacao) {
        this.motivacao = motivacao;
    }

    public Usuario getUsuarioAutor() {
        return usuarioAutor;
    }

    public void setUsuarioAutor(Usuario usuarioAutor) {
        this.usuarioAutor = usuarioAutor;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
