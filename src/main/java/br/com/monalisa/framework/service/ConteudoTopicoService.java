package br.com.monalisa.framework.service;

import br.com.monalisa.framework.model.ConteudoTopico;
import br.com.monalisa.framework.repository.ConteudoTopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoTopicoService {
    @Autowired
    private ConteudoTopicoRepository conteudoTopicoRepository;

    public List<ConteudoTopico> buscarPorIdUsuario(Long idUsuario){
        return conteudoTopicoRepository.buscaPorIdUsuario(idUsuario);
    }


}
