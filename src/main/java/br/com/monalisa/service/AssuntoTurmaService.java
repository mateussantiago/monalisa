package br.com.monalisa.service;

import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.repository.AssuntoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoTurmaService {
    @Autowired
    private AssuntoTurmaRepository assuntoTurmaRepository;

    public AssuntoTurma salvar(AssuntoTurma assuntoTurma) {
        return assuntoTurmaRepository.save(assuntoTurma);
    }

    public List<AssuntoTurma> buscarTodos() {
        return assuntoTurmaRepository.findAll();
    }

    public Optional<AssuntoTurma> buscarPorId(Long id) {
        return assuntoTurmaRepository.findById(id);
    }

    public AssuntoTurma buscarAssuntoTurmaPorIdAssuntoIdTurma(Long assunto, Long turma){
        return assuntoTurmaRepository.findAssuntoTurmaByAssuntoAndTurma(assunto, turma);
    }
}
