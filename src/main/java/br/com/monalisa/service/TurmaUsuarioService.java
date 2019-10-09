package br.com.monalisa.service;

import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.exception.OperacaoInvalidaException;
import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.repository.TurmaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaUsuarioService {

	@Autowired
	private TurmaUsuarioRepository turmaUsuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private TurmaService turmaService;

	public TurmaUsuario salvar(TurmaUsuario turmaUsuario) {
		return turmaUsuarioRepository.save(turmaUsuario);
	}

	public List<TurmaUsuario> buscarPorIdUsuario(Long idUsuario) throws EntidadeNaoEncontradaException {
		return turmaUsuarioRepository.buscarPorIdUsuario(idUsuario);
	}

	public TurmaUsuario seguirTurma(Long idTurma, Long idUsuario) {
		Turma turma = turmaService.buscarPorId(idTurma);

		if (turma == null){
			throw new EntidadeNaoEncontradaException("Turma não encontrada.");
		}

		Usuario usuario = usuarioService.buscarPorId(idUsuario);

		if (usuario == null){
			throw new EntidadeNaoEncontradaException("Usuário não encontrado.");
		}

		TurmaUsuario turmaUsuario = new TurmaUsuario();
		turmaUsuario.setTurma(turma);
		turmaUsuario.setUsuario(usuario);

		return turmaUsuarioRepository.save(turmaUsuario);
	}

	public TurmaUsuario deixarSeguirTurma(Long idTurma, Long idUsuario) throws OperacaoInvalidaException {
		TurmaUsuario turmaUsuario = turmaUsuarioRepository.buscarPorIdTurmaEIdUsuario(idTurma, idUsuario);

		if (turmaUsuario == null){
			throw new OperacaoInvalidaException("Esse usuário não segue essa turma.");
		}

		turmaUsuario.setAtivo(false);

		return turmaUsuarioRepository.save(turmaUsuario);
	}
}
