package br.com.monalisa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "assuntoturma")
public class AssuntoTurma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_assuntoturma", allocationSize = 1)
    @Column(name = "id_assuntoturma")
    private Long idAssuntoTurma;

    @ManyToOne
    @JoinColumn(name = "id_assunto")
    private Assunto assunto;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Column(name = "ativo")
    private boolean ativo;

    @OneToMany(mappedBy = "assuntoTurma", cascade = CascadeType.ALL)
    private Set<Postagem> postagem;

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Long getIdAssuntoTurma() {
        return idAssuntoTurma;
    }

    public void setIdAssuntoTurma(Long idAssuntoTurma) {
        this.idAssuntoTurma = idAssuntoTurma;
    }

    public Set<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(Set<Postagem> postagem) {
        this.postagem = postagem;
    }
}
