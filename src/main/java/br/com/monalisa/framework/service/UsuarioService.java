package br.com.monalisa.framework.service;

import br.com.monalisa.framework.exception.NovoUsuarioComEmailExistenteException;
import br.com.monalisa.framework.exception.NovoUsuarioComLoginExistenteException;
import br.com.monalisa.framework.model.Usuario;
import br.com.monalisa.framework.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(Usuario usuario) throws Exception {
        Usuario usuarioValidacao = usuarioRepository.buscarPorEmail(usuario.getEmail());

        if (usuarioValidacao != null) {
            throw new NovoUsuarioComEmailExistenteException("Email informado já está cadastrado no sistema.");
        }

        usuarioValidacao = usuarioRepository.buscarPorLogin(usuario.getLogin());

        if (usuarioValidacao != null) {
            throw new NovoUsuarioComLoginExistenteException("Login informado já está cadastrado no sistema.");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.buscarPorEmail(email);
    }

    public Usuario buscarPorLogin(String login) {
        return usuarioRepository.buscarPorLogin(login);
    }
}
