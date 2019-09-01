package br.com.monalisa.service;

import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.repository.TurmaUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaUsuarioService {
    TurmaUsuarioRepository turmaUsuarioRepository;

    public TurmaUsuario save(TurmaUsuario assuntoTurma) {
        return turmaUsuarioRepository.save(assuntoTurma);
    }

    public List<TurmaUsuario> findAll() {
        return turmaUsuarioRepository.findAll();
    }

    public Optional<TurmaUsuario> findOne(Long id) {
        return turmaUsuarioRepository.findById(id);
    }
}
