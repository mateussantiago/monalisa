package br.com.monalisa.service;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.model.Usuario;

public interface UsuarioService {

    Usuario registrarUsuario(UsuarioDTO usuarioDTO);

    Usuario findByEmail(String email);

    Usuario findByLoginAndPassword(String login, String senha);

}
