package br.com.monalisa.service;

import java.util.List;

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
		Usuario usuario = usuarioService.findByIdUsuario(idUsuario);
		TurmaUsuario turmaUsuario = new TurmaUsuario();
		turmaUsuario.setTurma(turma);
		turmaUsuario.setUsuario(usuario);

		return turmaUsuarioRepository.save(turmaUsuario);
	}

	public TurmaUsuario deixarSeguirTurma(Long idTurma, Long idUsuario) {
		TurmaUsuario turmaUsuario = turmaUsuarioRepository.findByIdTurmaAndIdUsuario(idTurma, idUsuario);

		if (turmaUsuario != null) {
			turmaUsuario.setAtivo(false);
			turmaUsuario = turmaUsuarioRepository.save(turmaUsuario);
		}

		return turmaUsuario;
	}
}
