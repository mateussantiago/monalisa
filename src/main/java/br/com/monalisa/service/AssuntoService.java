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

    public Assunto salvar(Assunto assunto) {
        return assuntoRepository.save(assunto);
    }

    public List<Assunto> buscarTodos() {
        return assuntoRepository.findAll();
    }

    public Optional<Assunto> buscarPorId(Long id) {
        return assuntoRepository.findById(id);
    }
}
