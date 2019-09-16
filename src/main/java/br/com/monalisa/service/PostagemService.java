package br.com.monalisa.service;

import br.com.monalisa.dto.PostagemDTO;
import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.model.*;
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

    public List<Postagem> buscarTodos() {
        return postagemRepository.buscarTodos();
    }

    public Postagem buscarPorId(Long id) {
        return postagemRepository.buscarPorId(id);
    }

    public Postagem salvar(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem postar(PostagemDTO postagemDTO, Usuario usuario) {
        Postagem postagemGenitora = postagemRepository.getOne(postagemDTO.getPostagemGenitora());

        if (postagemGenitora == null) {
            throw new EntidadeNaoEncontradaException("Não existe uma postagem anterior com está referência para adicionar um comentário.");
        }

        AssuntoTurma assuntoTurma = assuntoTurmaService.buscarPorIdAssuntoEIdTurma(postagemDTO.getAssunto(), postagemDTO.getTurma());

        if (assuntoTurma == null) {
            throw new EntidadeNaoEncontradaException("Não foi possível identificar uma referência dessa turma com este assunto.");
        }

        Postagem postagem = new Postagem();
        postagem.setTexto(postagemDTO.getTexto());
        postagem.setUsuarioAutor(usuario);
        postagem.setPostagemGenitora(postagemGenitora);
        postagem.setAssuntoTurma(assuntoTurma);

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
