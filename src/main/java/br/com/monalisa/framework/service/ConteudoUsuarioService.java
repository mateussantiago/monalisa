package br.com.monalisa.framework.service;

import br.com.monalisa.framework.model.ConteudoUsuario;
import br.com.monalisa.framework.repository.ConteudoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoUsuarioService {
    @Autowired
    private ConteudoUsuarioRepository conteudoUsuarioRepository;

    public List<ConteudoUsuario> buscarPorIdUsuario(Long idUsuario) {
        return conteudoUsuarioRepository.buscarPorIdUsuario(idUsuario);
    }
}
