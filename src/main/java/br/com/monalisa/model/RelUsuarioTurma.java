package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

public class RelUsuarioTurma {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_postagem", allocationSize = 1)
    @Column(name = "id_postagem")
    private Long idRelUsuarioTurma;

    @ManyToOne
    @MapsId("id_usuario")
    @JoinColumn(name = "id_usuario")
    Usuario usuario;

    @ManyToOne
    @MapsId("id_turma")
    @JoinColumn(name = "id_turma")
    Turma turma;

    @NotBlank
    @Column(name = "ativo")
    private boolean ativo;

    public Long getIdRelUsuarioTurma() {
        return idRelUsuarioTurma;
    }

    public void setIdRelUsuarioTurma(Long idRelUsuarioTurma) {
        this.idRelUsuarioTurma = idRelUsuarioTurma;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
