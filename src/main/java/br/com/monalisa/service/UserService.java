package br.com.monalisa.service;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.exception.NovoUsuarioComEmailExistenteException;
import br.com.monalisa.exception.NovoUsuarioComLoginEmUsoException;
import br.com.monalisa.exception.UsuarioComCampoNaoInformadoException;
import br.com.monalisa.model.User;
import br.com.monalisa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(UsuarioDTO usuarioDTO) throws NovoUsuarioComEmailExistenteException,
            NovoUsuarioComLoginEmUsoException, UsuarioComCampoNaoInformadoException {

        String validacaoCamposUsuario = validarCamposUsuario(usuarioDTO);
        Boolean usuarioComEmailCadastrado = userRepository.findByEmail(usuarioDTO.getEmail()).isPresent();
        Boolean usuarioComLoginCadastrado = userRepository.findByLogin(usuarioDTO.getLogin()).isPresent();

        if (!validacaoCamposUsuario.isEmpty())
            throw new UsuarioComCampoNaoInformadoException(validacaoCamposUsuario);

        if (usuarioComEmailCadastrado)
            throw new NovoUsuarioComEmailExistenteException("Email informado já está em uso.");

        else if (usuarioComLoginCadastrado)
            throw new NovoUsuarioComLoginEmUsoException("Login informado já está em uso.");

        User usuario = new User();
        usuario.setName(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(usuarioDTO.getSenha());
        usuario.setAtivo(true);

        return userRepository.save(usuario);
    }

    public User findById(Long idUsuario) throws EntidadeNaoEncontradaException {
        User usuario = userRepository.findById(idUsuario).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Usuário com id informado não encontrado."));

        return usuario;
    }

    public User findByEmail(String email) throws EntidadeNaoEncontradaException {
        User usuario = userRepository.findByEmail(email).orElseThrow(() ->
                new EntidadeNaoEncontradaException("Usuário com email informado não encontrado."));

        return usuario;
    }

    public User findByLogin(String login) throws EntidadeNaoEncontradaException {
        User usuario = userRepository.findByLogin(login).orElseThrow(() ->
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
