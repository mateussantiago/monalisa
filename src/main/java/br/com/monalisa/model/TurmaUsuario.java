package br.com.monalisa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "turma_usuario")
public class TurmaUsuario implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenerator")
	@SequenceGenerator(name = "seqGenerator", sequenceName = "public.turma_usuario_seq", allocationSize = 1)
	@Column(name = "id_turma_usuario")
	private Long idTurmaUsuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_turma")
	private Turma turma;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@Column(name = "ativo")
	private Boolean ativo = true;

	public Long getIdTurmaUsuario() {
		return idTurmaUsuario;
	}

	public void setIdTurmaUsuario(Long idTurmaUsuario) {
		this.idTurmaUsuario = idTurmaUsuario;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
