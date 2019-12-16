package br.com.monalisa.service;

import br.com.monalisa.dto.PostagemDTO;
import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.exception.PostagemSemConteudoException;
import br.com.monalisa.model.AssuntoTurma;
import br.com.monalisa.model.Postagem;
import br.com.monalisa.model.User;
import br.com.monalisa.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private AssuntoTurmaService assuntoTurmaService;

    public List<Postagem> buscarPostagensPrincipais(User usuario){
        return postagemRepository.buscarPrincipais(usuario.getIdUser());
    }

    public List<Postagem> buscarPostagensPorTurma(Long idTurma){
        return  postagemRepository.buscarPostagensPorTurma(idTurma);
    }

    public List<Postagem> buscarPostagensPorTurmaEAssunto(Long idTurma, Long idAssunto){
        return postagemRepository.buscarPostagensPorTurmaEAssunto(idTurma, idAssunto);
    }

    public List<Postagem> buscarTodos() {
        return postagemRepository.buscarTodos();
    }

    public Postagem buscarPorId(Long id) {
        return postagemRepository.buscarPorId(id);
    }

    public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem postar(PostagemDTO postagemDTO, User usuario) {
        Postagem postagemGenitora = null;

        if (postagemDTO.getIdPostagemGenitora() != null){
            postagemGenitora = buscarPorId(postagemDTO.getIdPostagemGenitora());
        }
        if (postagemDTO.getConteudo() == null || postagemDTO.getConteudo() == "") {
            throw new PostagemSemConteudoException("A postagem não pode ter conteúdo vazio.");
        }

        AssuntoTurma assuntoTurma = assuntoTurmaService.buscarPorId(postagemDTO.getIdAssuntoTurma());

        if (assuntoTurma == null) {
            throw new EntidadeNaoEncontradaException("Assunto da postagem não pode ser vazio.");
        }
        Postagem postagem = new Postagem();
        postagem.setConteudo(postagemDTO.getConteudo());
        postagem.setAssuntoTurma(assuntoTurma);
        postagem.setUsuarioAutor(usuario);
        postagem.setPostagemGenitora(postagemGenitora);

        return salvar(postagem);
    }

    public Postagem gostar(Long id){
        Postagem postagem = this.buscarPorId(id);

        if (postagem == null){
            throw new EntidadeNaoEncontradaException("Postagem não encontrada.");
        }

        postagem.setCurtidasPositivas(postagem.getCurtidasPositivas()+1);

        return salvar(postagem);
    }

    public Postagem desgostar(Long id){
        Postagem postagem = this.buscarPorId(id);

        if (postagem == null){
            throw new EntidadeNaoEncontradaException("Postagem não encontrada.");
        }

        postagem.setCurtidasNegativas(postagem.getCurtidasNegativas()+1);

        return salvar(postagem);
    }
}
