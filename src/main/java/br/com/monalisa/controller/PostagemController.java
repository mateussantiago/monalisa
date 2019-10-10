package br.com.monalisa.controller;

import br.com.monalisa.dto.PostagemDTO;
import br.com.monalisa.model.*;
import br.com.monalisa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("postagem")
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/postar", method = RequestMethod.POST)
    public String postar(Model model, HttpSession httpSession, PostagemDTO postagemDTO){
        try {
            Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
            Postagem postagem = postagemService.postar(postagemDTO, usuario);
        }
        catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }

    @RequestMapping(value = "/{id}/gostar")
    public String gostar(Model model, @PathVariable(value = "id") Long id){
        postagemService.gostar(id);

        return "redirect:/feed";
    }

    @RequestMapping(value = "/{id}/desgostar")
    public String desgostar(Model model, @PathVariable(value = "id") Long id){
        postagemService.desgostar(id);

        return "redirect:/feed";
    }
}
