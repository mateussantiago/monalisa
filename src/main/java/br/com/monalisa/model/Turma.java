package br.com.monalisa.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "turma")
public class Turma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
    @SequenceGenerator(name = "seqGenerator", sequenceName = "public.seq_id_turma", allocationSize = 1)
    @Column(name = "id_turma")
    private Long idTurma;

    @NotBlank
    @Column(name = "descricao")
    private String descricao;

    public Long getIdTurma() { return idTurma; }

    public void setIdTurma(Long idTurma) { this.idTurma = idTurma; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }


}
