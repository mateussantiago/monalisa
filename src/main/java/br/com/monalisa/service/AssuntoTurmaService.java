package br.com.monalisa.service;

import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.repository.AssuntoTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuntoTurmaService {
    @Autowired
    private AssuntoTurmaRepository assuntoTurmaRepository;

    public AssuntoTurma salvar(AssuntoTurma assuntoTurma) {
        return assuntoTurmaRepository.save(assuntoTurma);
    }

    public List<AssuntoTurma> buscarTodos() {
        return assuntoTurmaRepository.buscarTodos();
    }

    public AssuntoTurma buscarPorId(Long id) {
        return assuntoTurmaRepository.buscarPorId(id);
    }

    public AssuntoTurma buscarPorIdAssuntoEIdTurma(Long assunto, Long turma){
        return assuntoTurmaRepository.buscarPorAssuntoETurma(assunto, turma);
    }
}
