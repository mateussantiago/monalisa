package br.com.monalisa.service;

import java.util.List;

import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.exception.OperacaoInvalidaException;
import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.repository.TurmaUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaUsuarioService {

	@Autowired
	private TurmaUsuarioRepository turmaUsuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TurmaService turmaService;

	public TurmaUsuario save(TurmaUsuario turmaUsuario) {
		return turmaUsuarioRepository.save(turmaUsuario);
	}

	public List<TurmaUsuario> findByIdUsuario(Long idUsuario) {
		return turmaUsuarioRepository.findByIdUsuario(idUsuario);
	}

	public TurmaUsuario seguirTurma(Long idTurma, Long idUsuario) {
		Turma turma = turmaService.findByIdTurma(idTurma);

		if (turma == null){
			throw new EntidadeNaoEncontradaException("Turma não encontrada.");
		}

		Usuario usuario = usuarioService.findByIdUsuario(idUsuario);

		if (usuario == null){
			throw new EntidadeNaoEncontradaException("Usuário não encontrado.");
		}

		TurmaUsuario turmaUsuario = new TurmaUsuario();
		turmaUsuario.setTurma(turma);
		turmaUsuario.setUsuario(usuario);

		return turmaUsuarioRepository.save(turmaUsuario);
	}

	public TurmaUsuario deixarSeguirTurma(Long idTurma, Long idUsuario) {
		TurmaUsuario turmaUsuario = turmaUsuarioRepository.findByIdTurmaAndIdUsuario(idTurma, idUsuario);

		if (turmaUsuario == null){
			throw new OperacaoInvalidaException("Esse usuário não segue essa turma.");
		}

		turmaUsuario.setAtivo(false);

		return turmaUsuarioRepository.save(turmaUsuario);
	}
}
