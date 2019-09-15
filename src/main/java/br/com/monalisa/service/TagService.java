package br.com.monalisa.service;

import br.com.monalisa.model.Tag;
import br.com.monalisa.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class TagService  {
    @Autowired
    private TagRepository tagRepository;

    public Tag salvar(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> buscarTodos() {
        return tagRepository.findAll();
    }

    public Optional<Tag> buscarPorId(Long id) {
        return tagRepository.findById(id);
    }
}
