package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "tag_turma")
public class TagTurma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_tag_turma", allocationSize = 1)
    @Column(name = "id_tag_turma")
    private Long idTagTurma;

    @ManyToOne
    @JoinColumn(name = "id_tag")
    private Tag tag;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @NotNull
    @Column(name = "ativo")
    private boolean ativo;

    public Long getIdTagTurma() {
        return idTagTurma;
    }

    public void setIdTagTurma(Long idTagTurma) {
        this.idTagTurma = idTagTurma;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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
}
