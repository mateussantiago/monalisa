package br.com.monalisa.service;

import br.com.monalisa.model.Assunto;
import br.com.monalisa.repository.AssuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssuntoService {
    @Autowired
    private AssuntoRepository assuntoRepository;

    public List<Assunto> buscarTodos() {
        return assuntoRepository.buscarTodos();
    }

    public Assunto buscarPorId(Long id) {
        return assuntoRepository.buscarPorId(id);
    }

    public Assunto salvar(Assunto assunto) {
        return assuntoRepository.save(assunto);
    }

    public List<Assunto> buscarAssuntoPorNome(String assunto){
        return assuntoRepository.buscarAssuntoPorNome(assunto);
    }
}
