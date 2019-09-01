package br.com.monalisa.service;

import br.com.monalisa.model.TagTurma;
import br.com.monalisa.repository.TagTurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagTurmaService {
    TagTurmaRepository tagTurmaRepository;

    public TagTurma save(TagTurma turma) {
        return tagTurmaRepository.save(turma);
    }

    public List<TagTurma> findAll() {
        return tagTurmaRepository.findAll();
    }

    public Optional<TagTurma> findOne(Long id) {
        return tagTurmaRepository.findById(id);
    }
}
