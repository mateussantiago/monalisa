package br.com.monalisa.service;

import br.com.monalisa.model.Turma;
import br.com.monalisa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService  {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> buscarTodos() {
        return turmaRepository.buscarTodos();
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.buscarPorId(id);
    }

    public List<Turma> buscarPorNome(String nome) {
        return turmaRepository.buscarPorNome(nome);
    }

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> buscarTurmasPorAssunto(String assunto){
        return turmaRepository.buscarTurmasPorAssunto(assunto);
    }

    public List<Turma> buscarTurmasPorTag(String tag){
        return turmaRepository.buscarTurmasPorTag(tag);
    }
}
