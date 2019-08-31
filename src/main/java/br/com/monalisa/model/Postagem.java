package br.com.monalisa.model;

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
    private Long curtidas_negativas;

    public Long getIdPostagem(){  return idPostagem;  }

    public void setIdPostagem(Long idPostagem) { this.idPostagem = idPostagem;  }

    public String getTexto(){ return texto; }

    public void setTexto(String texto) { this.texto = texto; }

    public Long getCurtidasPositivas() { return curtidasPositivas; }

    public void setCurtidasPositivas(Long curtidasPositivas) { this.curtidasPositivas = curtidasPositivas; }

    public Long getCurtidas_negativas() { return curtidas_negativas; }

    public void setCurtidas_negativas(Long curtidas_negativas) { this.curtidas_negativas = curtidas_negativas; }

    public Long getUsuarioAutor() { return usuarioAutor; }

    public void setUsuarioAutor(Long usuarioAutor) { this.usuarioAutor = usuarioAutor; }
}
