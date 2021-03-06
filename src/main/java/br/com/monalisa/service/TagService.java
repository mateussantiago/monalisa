package br.com.monalisa.service;

import br.com.monalisa.model.Tag;
import br.com.monalisa.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService  {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> buscarTodos() {
        return tagRepository.buscarTodos();
    }

    public Tag buscarPorId(Long id) {
        return tagRepository.buscarPorId(id);
    }

    public Tag salvar(Tag tag) {
        return tagRepository.save(tag);
    }
}
