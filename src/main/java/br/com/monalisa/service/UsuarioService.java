package br.com.monalisa.service;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuario.setAtivo(true);

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long idUsuario) {
        return usuarioRepository.buscarPorId(idUsuario);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.buscarPorEmail(email);
    }

    public Usuario buscarPorLogin(String login) {
        return usuarioRepository.buscarPorLogin(login);
    }
}
