package br.com.framework.service;

import br.com.framework.model.Topico;
import br.com.framework.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    public List<Topico> buscarTodos() {
        return topicoRepository.findAll();
    }

    public Topico buscarPorId(Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);

        return topico.orElse( null );
    }

    public List<Topico> buscarPorIdUsuario(Long idUsuario){
        return topicoRepository.buscaPorIdUsuario(idUsuario);
    }
}
