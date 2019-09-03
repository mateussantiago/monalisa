package br.com.monalisa.controller;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.model.*;
import br.com.monalisa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/postagem")
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    private TurmaService turmaService;
    private AssuntoService assuntoService;
    private AssuntoTurmaService assuntoTurmaService;
    private UsuarioService usuarioService;

    @RequestMapping("")
    public String postar(Model model){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNome("nome: usuario teste");
        usuarioDTO.setEmail("email: usuario teste");
        usuarioDTO.setLogin("login: usuario teste");
        usuarioDTO.setSenha("senha: usuario teste");


        Usuario usuario = usuarioService.registrarUsuario(usuarioDTO);

        Turma turma = new Turma();
        turma.setDescricao("desc: turma teste");
        turma.setNome("nome: turma teste");

        Assunto assunto = new Assunto();
        assunto.setNome("nome: assunto teste");
        assunto.setDescricao("desc: assunto teste");

        turmaService.save(turma);
        assuntoService.save(assunto);

        AssuntoTurma assuntoTurma = new AssuntoTurma();
        assuntoTurma.setAssunto(assunto);
        assuntoTurma.setTurma(turma);
        assuntoTurma.setAtivo(true);

        assuntoTurmaService.save(assuntoTurma);

        Postagem postagem = new Postagem();
        postagem.setTexto("text: postagem teste");
        postagem.setAssuntoTurma(assuntoTurma);
        //  postagem.setUsuarioAutor(usuario);


        return "index";
    }

}
