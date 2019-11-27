package br.com.framework.service;

import br.com.framework.exception.EntidadeNaoEncontradaException;
import br.com.framework.repository.DenunciaRepository;
import br.com.framework.model.Denuncia;
import br.com.framework.model.Postagem;
import br.com.framework.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PostagemService postagemService;

    @Autowired
    private PunicaoService punicaoService;

    @Autowired
    private DenunciaRepository denunciaRepository;

    public Denuncia salvar(Denuncia denuncia) {
        return denunciaRepository.save(denuncia);
    }

    public Denuncia denunciar(Long idUsuario, Long idPostagem, String motivacao) {
        Usuario usuario = usuarioService.buscarPorId(idUsuario);

        if (usuario == null) {
            throw new EntidadeNaoEncontradaException("Usuario não encontrado");
        }

        Postagem postagem = postagemService.buscarPorId(idPostagem);

        if (postagem == null) {
            throw new EntidadeNaoEncontradaException("Postagem nao encontrada");
        }

        Denuncia denuncia = new Denuncia();
        denuncia.setUsuarioAutor(usuario);
        denuncia.setPostagem(postagem);
        denuncia.setMotivacao(motivacao);

        denuncia = salvar(denuncia);

        punicaoService.talvezPunir(idPostagem);

        return denuncia;
    }

    public List<Denuncia> recuperarDenunciasPorIdPostagem(Long idPostagem){
        List<Denuncia> denunciasRecuperadas = denunciaRepository.recuperarDenunciasPorIdPostagem(idPostagem);

        if (denunciasRecuperadas.isEmpty())
            throw new EntidadeNaoEncontradaException("Nenhuma denuncia relacionada à postagem passada foi achada!");

        return denunciasRecuperadas;
    }
}
