package br.com.monalisa.service;

import br.com.monalisa.model.TagTurma;
import br.com.monalisa.repository.TagTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagTurmaService {
    @Autowired
    private TagTurmaRepository tagTurmaRepository;

    public TagTurma save(TagTurma turma) {
        return tagTurmaRepository.save(turma);
    }

    public List<TagTurma> findAll() {
        return tagTurmaRepository.findAll();
    }

    public Optional<TagTurma> findById(Long id) {
        return tagTurmaRepository.findById(id);
    }
}
