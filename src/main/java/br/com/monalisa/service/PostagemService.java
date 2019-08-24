package br.com.monalisa.service;

import br.com.monalisa.model.Postagem;
import br.com.monalisa.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class PostagemService  {
    @Autowired
    private PostagemRepository postagemRepository;

    public Postagem save(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public List<Postagem> findAll() {
        return postagemRepository.findAll();
    }

    public Optional<Postagem> findOne(Long id) {
        return postagemRepository.findById(id);
    }


}
