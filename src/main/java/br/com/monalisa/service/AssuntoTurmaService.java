package br.com.monalisa.service;

import br.com.monalisa.model.Assunto;
import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.model.Postagem;
import br.com.monalisa.repository.AssuntoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoTurmaService {
    @Autowired
    private AssuntoTurmaRepository assuntoTurmaRepository;

    public AssuntoTurma save(AssuntoTurma assuntoTurma) {
        return assuntoTurmaRepository.save(assuntoTurma);
    }

    public List<AssuntoTurma> findAll() {
        return assuntoTurmaRepository.findAll();
    }

    public Optional<AssuntoTurma> findOne(Long id) {
        return assuntoTurmaRepository.findById(id);
    }

    public AssuntoTurma buscarAssuntoTurmaPorIdAssuntoEIdTurma(Long assunto, Long turma){
        return assuntoTurmaRepository.findAssuntoTurmaByAssuntoAndTurma(assunto, turma);
    }
}
