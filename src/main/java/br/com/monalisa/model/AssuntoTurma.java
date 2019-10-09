package br.com.monalisa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(schema = "public", name = "assunto_turma")
public class AssuntoTurma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_assunto_turma", allocationSize = 1)
    @Column(name = "id_assunto_turma")
    private Long idAssuntoTurma;

    @ManyToOne
    @JoinColumn(name = "id_assunto")
    private Assunto assunto;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @Column(name = "ativo")
    private boolean ativo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuarioCriador;

    @Column(name = "justificativa")
    private String justificativa;

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

    public Usuario getUsuarioCriador() { return usuarioCriador; }

    public void setUsuarioCriador(Usuario usuarioCriador) { this.usuarioCriador = usuarioCriador; }

    public String getJustificativa() { return justificativa; }

    public void setJustificativa(String justificativa) { this.justificativa = justificativa; }
}
