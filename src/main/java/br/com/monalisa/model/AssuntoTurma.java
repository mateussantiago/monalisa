package br.com.monalisa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "assuntoturma")
public class AssuntoTurma implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_assunto")
    private Assunto assunto;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Column(name = "ativo")
    private boolean ativo;

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
}
