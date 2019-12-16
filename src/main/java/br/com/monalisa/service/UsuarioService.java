package br.com.monalisa.service;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.exception.NovoUsuarioComEmailExistenteException;
import br.com.monalisa.exception.NovoUsuarioComLoginEmUsoException;
import br.com.monalisa.exception.UsuarioComCampoNaoInformadoException;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) throws NovoUsuarioComEmailExistenteException,
            NovoUsuarioComLoginEmUsoException, UsuarioComCampoNaoInformadoException {

        String validacaoCamposUsuario = validarCamposUsuario(usuarioDTO);
        Boolean usuarioComEmailCadastrado = usuarioRepository.buscarPorEmail(usuarioDTO.getEmail()).isPresent();
        Boolean usuarioComLoginCadastrado = usuarioRepository.buscarPorLogin(usuarioDTO.getLogin()).isPresent();

        if (!validacaoCamposUsuario.isEmpty())
            throw new UsuarioComCampoNaoInformadoException(validacaoCamposUsuario);

        if (usuarioComEmailCadastrado)
            throw new NovoUsuarioComEmailExistenteException("Email informado já está em uso.");

        else if (usuarioComLoginCadastrado)
            throw new NovoUsuarioComLoginEmUsoException("Login informado já está em uso.");

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setAtivo(true);

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarPorId(Long idUsuario) throws EntidadeNaoEncontradaException {
        Usuario usuario = usuarioRepository.buscarPorId(idUsuario).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Usuário com id informado não encontrado."));

        return usuario;
    }

    public Usuario buscarPorEmail(String email) throws EntidadeNaoEncontradaException {
        Usuario usuario = usuarioRepository.buscarPorEmail(email).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Usuário com email informado não encontrado."));

        return usuario;
    }

    public Usuario buscarPorLogin(String login) throws EntidadeNaoEncontradaException {
        Usuario usuario = usuarioRepository.buscarPorLogin(login).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Usuário com o login informado não encontrado."));

        return usuario;
    }

    private String validarCamposUsuario(UsuarioDTO usuarioDTO) {
        if (usuarioDTO.getNome().isEmpty() || usuarioDTO.getNome() == "")
            return "Nome não informado.";
        if (usuarioDTO.getEmail().isEmpty() || usuarioDTO.getEmail() == "")
            return "Email não informado.";
        if (usuarioDTO.getLogin().isEmpty() || usuarioDTO.getLogin() == "")
            return "Login não informado.";
        if(usuarioDTO.getSenha().isEmpty() || usuarioDTO.getSenha() == "")
            return "Senha não informada.";

        return "";
    }
}
