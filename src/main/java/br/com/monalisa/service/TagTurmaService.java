package br.com.monalisa.service;

import br.com.monalisa.model.TagTurma;
import br.com.monalisa.model.Turma;
import br.com.monalisa.repository.TagTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagTurmaService {
    @Autowired
    private TagTurmaRepository tagTurmaRepository;

    public List<TagTurma> buscarTodos() {
        return tagTurmaRepository.buscarTodos();
    }

    public TagTurma buscarPorId(Long id) {
        return tagTurmaRepository.buscarPorId(id);
    }

    public TagTurma salvar(TagTurma turma) {
        return tagTurmaRepository.save(turma);
    }

    public List<Turma> buscarTurmasPorTag(String tag){
        return tagTurmaRepository.buscarTurmaPorTag(tag);
    }
}
