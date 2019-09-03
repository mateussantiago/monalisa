package br.com.monalisa.controller;

import br.com.monalisa.dto.PostagemDTO;
import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.model.*;
import br.com.monalisa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/postagem")
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    private UsuarioService usuarioService;
    private TurmaService turmaService;
    private AssuntoService assuntoService;
    private AssuntoTurmaService assuntoTurmaService;

    @PostMapping(value = "/postar")
    public String postar(Model model, HttpSession httpSession, PostagemDTO postagemDTO){
        Long idUsuario = (Long) httpSession.getAttribute("idUsuario");
        Usuario usuario = usuarioService.findByIdUsuario(idUsuario);

        if (usuario == null){
            throw new RuntimeException("Não existe usuário ativo nessa sessão");
        }

//        return postagemService.postar(postagemDTO, usuario);
         return "feed/feed";
    }
}
