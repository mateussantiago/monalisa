package br.com.framework.service;

import br.com.framework.repository.ConteudoUsuarioRepository;
import br.com.framework.model.ConteudoUsuario;
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
