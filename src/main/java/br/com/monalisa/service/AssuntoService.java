package br.com.monalisa.service;

import br.com.monalisa.model.Assunto;
import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.repository.AssuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuntoService {
    @Autowired
    private AssuntoRepository assuntoRepository;

    public Assunto save(Assunto assunto) {
        return assuntoRepository.save(assunto);
    }

    public List<Assunto> findAll() {
        return assuntoRepository.findAll();
    }

    public Optional<Assunto> findById(Long id) {
        return assuntoRepository.findById(id);
    }
}
