package br.com.framework.service;

import br.com.framework.repository.ConteudoTopicoRepository;
import br.com.framework.model.ConteudoTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoTopicoService {
    @Autowired
    protected ConteudoTopicoRepository conteudoTopicoRepository;

    public List<ConteudoTopico> buscarPorIdUsuario(Long idUsuario){
        return conteudoTopicoRepository.buscaPorIdUsuario(idUsuario);
    }
}
