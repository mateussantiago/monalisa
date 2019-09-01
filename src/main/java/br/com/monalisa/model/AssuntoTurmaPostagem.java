package br.com.monalisa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "assuntoturmapostagem")
public class AssuntoTurmaPostagem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_assuntoturma_postagem", allocationSize = 1)
    @Column(name = "id_assuntoturma_postagem")
    private Long idAssuntoTurmaPostagem;

    @ManyToOne
    @JoinColumn(name = "id_assuntoturma")
    private AssuntoTurma assuntoTurma;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;

    @Column(name = "ativo")
    private boolean ativo;

    public Long getIdAssuntoTurmaPostagem() {
        return idAssuntoTurmaPostagem;
    }

    public void setIdAssuntoTurmaPostagem(Long idAssuntoTurmaPostagem) {
        this.idAssuntoTurmaPostagem = idAssuntoTurmaPostagem;
    }

    public AssuntoTurma getAssuntoTurma() {
        return assuntoTurma;
    }

    public void setAssuntoTurma(AssuntoTurma assuntoTurma) {
        this.assuntoTurma = assuntoTurma;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
