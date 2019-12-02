package br.com.monalisa.service;

import br.com.framework.model.Usuario;
import br.com.framework.repository.UsuarioRepository;
import br.com.framework.service.UsuarioService;
import br.com.monalisa.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMonalisaService extends UsuarioService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario validarCamposUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO.getNome().isEmpty() || usuarioDTO.getNome().equals(""))
            throw new Exception("Nome não informado.");
        if (usuarioDTO.getEmail().isEmpty() || usuarioDTO.getEmail().equals(""))
            throw new Exception("Email não informado.");
        if (usuarioDTO.getLogin().isEmpty() || usuarioDTO.getLogin().equals(""))
            throw new Exception("Login não informado.");
        if(usuarioDTO.getSenha().isEmpty() || usuarioDTO.getSenha().equals(""))
            throw new Exception("Senha não informada.");

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuario.setAtivo(true);

        return usuario;
    }
}
