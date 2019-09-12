package br.com.monalisa.service;

import br.com.monalisa.dto.PostagemDTO;
import br.com.monalisa.model.*;
import br.com.monalisa.repository.PostagemRepository;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import java.util.List;

@Service
public class PostagemService {
    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private AssuntoTurmaService assuntoTurmaService;

    public List<Postagem> findAll() {
        return postagemRepository.findAll();
    }

    public Postagem findById(Long id) {
        return postagemRepository.findPostagemById(id);
    }

    public Postagem save(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public Postagem postar(PostagemDTO postagemDTO, Usuario usuario) {
        Postagem postagemGenitora = postagemRepository.getOne(postagemDTO.getPostagemGenitora());

        if (postagemGenitora == null) {
            throw new EntityNotFoundException("Não existe uma postagem anterior com está referência para adicionar um comentário.");
        }

        AssuntoTurma assuntoTurma = assuntoTurmaService.buscarAssuntoTurmaPorIdAssuntoEIdTurma(postagemDTO.getAssunto(), postagemDTO.getTurma());

        if (assuntoTurma == null) {
            throw new EntityNotFoundException("Não foi possível identificar uma referência dessa turma com este assunto.");
        }

        Postagem postagem = new Postagem();
        postagem.setTexto(postagemDTO.getTexto());
        postagem.setUsuarioAutor(usuario);
        postagem.setPostagemGenitora(postagemGenitora);
        postagem.setAssuntoTurma(assuntoTurma);

        return save(postagem);
    }
}
