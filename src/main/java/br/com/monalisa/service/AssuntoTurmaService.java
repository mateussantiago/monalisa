package br.com.monalisa.service;

import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.repository.AssuntoTurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoTurmaService {
    AssuntoTurmaRepository assuntoTurmaRepository;

    public AssuntoTurma save(AssuntoTurma assuntoTurma) {
        return assuntoTurmaRepository.save(assuntoTurma);
    }

    public List<AssuntoTurma> findAll() {
        return assuntoTurmaRepository.findAll();
    }

    public Optional<AssuntoTurma> findOne(Long id) {
        return assuntoTurmaRepository.findById(id);
    }
}
