package br.com.monalisa.service;

import br.com.monalisa.model.Turma;
import br.com.monalisa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class TurmaService  {
    @Autowired
    private TurmaRepository turmaRepository;

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) {
        return turmaRepository.findByIdTurma(id);
    }
}
