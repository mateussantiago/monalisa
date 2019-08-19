package br.com.monalisa.service;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    Usuario registrarUsuario(UsuarioDTO usuarioDTO);
}
