package br.com.monalisa.service;

import br.com.monalisa.model.AssuntoTurmaPostagem;
import br.com.monalisa.repository.AssuntoTurmaPostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoTurmaPostagemService {
    @Autowired
    private AssuntoTurmaPostagemRepository assuntoTurmaPostagemRepository;

    public AssuntoTurmaPostagem save(AssuntoTurmaPostagem tag) {
        return assuntoTurmaPostagemRepository.save(tag);
    }

    public List<AssuntoTurmaPostagem> findAll() {
        return assuntoTurmaPostagemRepository.findAll();
    }

    public Optional<AssuntoTurmaPostagem> findOne(Long id) {
        return assuntoTurmaPostagemRepository.findById(id);
    }


}
