package br.com.monalisa.framework.service;

import br.com.monalisa.framework.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.framework.model.Denuncia;
import br.com.monalisa.framework.model.Postagem;
import br.com.monalisa.framework.model.Usuario;
import br.com.monalisa.framework.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DenunciaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostagemService postagemService;

    @Autowired
    private DenunciaRepository denunciaRepository;

    public Denuncia salvar(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    public Denuncia denunciar(Long idUsuario, Long idPostagem, String motivacao) {

        Usuario usuario = usuarioService.buscarPorId(idUsuario);

        if (usuario == null) {
            throw new EntidadeNaoEncontradaException("Usuario nao encontrado");
        }

        Postagem postagem = postagemService.buscarPorId(idPostagem);

        if (postagem == null) {
            throw new EntidadeNaoEncontradaException("Postagem nao encontrada");
        }

        Denuncia denunciaCriada = new Denuncia();
        denunciaCriada.setUsuarioAutor(usuario);
        denunciaCriada.setPostagem(postagem);
        denunciaCriada.setAtivo(true);
        denunciaCriada.setProcessada(false);
        denunciaCriada.setMotivacao(motivacao);

        return salvar(denunciaCriada);
    }
}
