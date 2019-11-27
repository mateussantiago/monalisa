package br.com.framework.service;

import br.com.monalisa.dto.PostagemDTO;
import br.com.framework.exception.EntidadeNaoEncontradaException;
import br.com.framework.exception.PostagemSemConteudoException;
import br.com.framework.model.Topico;
import br.com.framework.repository.PostagemRepository;
import br.com.framework.model.Postagem;
import br.com.framework.model.Usuario;
import br.com.framework.utils.ComparadorPostagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private ComparadorPostagem comparadorPostagem;

    public PostagemService() {
        this(null);
    }

    public PostagemService(ComparadorPostagem comparadorPostagem) {
        this.comparadorPostagem = comparadorPostagem;
    }

    public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem buscarPorId(Long idPostagem) {
        return postagemRepository.buscarPorId(idPostagem);
    }

    public Postagem postar(PostagemDTO postagemDTO, Usuario usuario) {
        Postagem postagemGenitora = null;

        if (postagemDTO.getIdPostagemGenitora() != null){
            postagemGenitora = buscarPorId(postagemDTO.getIdPostagemGenitora());
        }
        if (postagemDTO.getTexto() == null || postagemDTO.getTexto() == "") {
            throw new PostagemSemConteudoException("A postagem não pode ter conteúdo vazio.");
        }

        Topico topico = topicoService.buscarPorId(postagemDTO.getIdTopico());

        if (topico == null) {
            throw new EntidadeNaoEncontradaException("Assunto da postagem não pode ser vazio.");
        }
        Postagem postagem = new Postagem();
        postagem.setTexto(postagemDTO.getTexto());
        postagem.setTopico(topico);
        postagem.setUsuarioAutor(usuario);
        postagem.setPostagemGenitora(postagemGenitora);

        return salvar(postagem);
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
        List<Postagem> postagens = postagemRepository.buscarPrincipais(usuario.getIdUsuario());
        postagens = ordenarPostagens(postagens);

        return postagens;
    }
}
