package br.com.monalisa.framework.service;

import br.com.monalisa.framework.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.framework.model.Postagem;
import br.com.monalisa.framework.model.Usuario;
import br.com.monalisa.framework.repository.PostagemRepository;
import br.com.monalisa.framework.utils.ComparadorPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    private ComparadorPostagem comparadorPostagem;

    public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem buscarPorId(Long idPostagem) {
        return postagemRepository.buscarPorId(idPostagem);
    }

    public void remover(Long idPostagem) {
        postagemRepository.remover(idPostagem);
    }

    public Postagem gostar(Long idPostagem) {
        Postagem postagem = this.buscarPorId(idPostagem);

        if (postagem == null){
            throw new EntidadeNaoEncontradaException("Postagem não encontrada.");
        }

        postagem.setCurtidasPositivas(postagem.getCurtidasPositivas()+1);

        return salvar(postagem);
    }

    public Postagem desgostar(Long idPostagem) {
        Postagem postagem = this.buscarPorId(idPostagem);

        if (postagem == null){
            throw new EntidadeNaoEncontradaException("Postagem não encontrada.");
        }

        postagem.setCurtidasNegativas(postagem.getCurtidasNegativas()+1);

        return salvar(postagem);
    }

    public List<Postagem> ordenarPostagens(List<Postagem> postagens) {
        Collections.sort(postagens, comparadorPostagem);

        return postagens;
    }

    public List<Postagem> buscarPostagensPrincipais(Usuario usuario){
        return postagemRepository.buscarPrincipais(usuario.getIdUsuario());
    }
}
