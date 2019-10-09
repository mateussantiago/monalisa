package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(schema = "public", name = "turma")
public class Turma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_turma", allocationSize = 1)
    @Column(name = "id_turma")
    private Long idTurma;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ativo")
    private Boolean ativo;

    @OneToMany(mappedBy = "turma")
    private List<AssuntoTurma> assuntoTurmas;

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public List<AssuntoTurma> getAssuntoTurmas() {
        return assuntoTurmas;
    }

    public void setAssuntoTurmas(List<AssuntoTurma> assuntoTurmas) {
        this.assuntoTurmas = assuntoTurmas;
    }
}
