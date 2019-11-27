package br.com.framework.service;

import br.com.framework.exception.EntidadeNaoEncontradaException;
import br.com.framework.exception.OperacaoInvalidaException;
import br.com.framework.model.Conteudo;
import br.com.framework.model.Usuario;
import br.com.framework.repository.ConteudoUsuarioRepository;
import br.com.framework.model.ConteudoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConteudoUsuarioService {
    @Autowired
    private ConteudoUsuarioRepository conteudoUsuarioRepository;

    @Autowired
    private ConteudoService conteudoService;

    @Autowired
    private UsuarioService usuarioService;

    public List<ConteudoUsuario> buscarPorIdUsuario(Long idUsuario) {
        return conteudoUsuarioRepository.buscarPorIdUsuario(idUsuario);
    }

    public ConteudoUsuario seguir(Long idConteudo, Long idUsuario) {
        Conteudo conteudo = conteudoService.buscarPorId(idConteudo);

        if (conteudo == null){
            throw new EntidadeNaoEncontradaException("Conteúdo não encontrado.");
        }

        Usuario usuario = usuarioService.buscarPorId(idUsuario);

        if (usuario == null){
            throw new EntidadeNaoEncontradaException("Usuário não encontrado.");
        }

        ConteudoUsuario conteudoUsuario = new ConteudoUsuario();
        conteudoUsuario.setConteudo(conteudo);
        conteudoUsuario.setUsuario(usuario);

        return conteudoUsuarioRepository.save(conteudoUsuario);
    }

    public ConteudoUsuario deixarSeguir(Long idTurma, Long idUsuario) throws OperacaoInvalidaException {
        ConteudoUsuario conteudoUsuario = conteudoUsuarioRepository.buscarPorIdConteudoIdUsuario(idTurma, idUsuario);

        if (conteudoUsuario == null){
            throw new OperacaoInvalidaException("Esse usuário não segue esse conteúdo.");
        }

        conteudoUsuario.setAtivo(false);

        return conteudoUsuarioRepository.save(conteudoUsuario);
    }
}
