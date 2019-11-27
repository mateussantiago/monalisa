package br.com.monalisa.service;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.framework.exception.NovoUsuarioComEmailExistenteException;
import br.com.framework.model.Usuario;
import br.com.framework.repository.UsuarioRepository;
import br.com.framework.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioMonalisaService extends UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private String validarCamposUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getNome().isEmpty() || usuarioDTO.getNome() == "")
            return "Nome não informado.";
        if (usuarioDTO.getEmail().isEmpty() || usuarioDTO.getEmail() == "")
            return "Email não informado.";
        if (usuarioDTO.getLogin().isEmpty() || usuarioDTO.getLogin() == "")
            return "Login não informado.";
        if(usuarioDTO.getSenha().isEmpty() || usuarioDTO.getSenha() == "")
            return "Senha não informada.";

        return null;
    }

    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        String validacaoCampos = validarCamposUsuario(usuarioDTO);
        Usuario usuarioValidacao = usuarioRepository.buscarPorEmail(usuarioDTO.getEmail());

        if (validacaoCampos != null) {
            throw new Exception(validacaoCampos);
        }

        if (usuarioValidacao != null) {
            throw new NovoUsuarioComEmailExistenteException("Email informado já está cadastrado no sistema.");
        }

        usuarioValidacao = usuarioRepository.buscarPorLogin(usuarioDTO.getLogin());

        if (usuarioValidacao != null) {
            throw new Exception("Login informado já está cadastrado no sistema.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        usuario.setAtivo(true);

        return usuarioRepository.save(usuario);
    }
}
