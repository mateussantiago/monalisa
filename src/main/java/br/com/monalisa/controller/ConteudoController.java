package br.com.monalisa.controller;

import br.com.framework.exception.OperacaoInvalidaException;
import br.com.framework.model.ConteudoUsuario;
import br.com.framework.model.Usuario;
import br.com.framework.service.ConteudoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ConteudoController {
    @Autowired
    private ConteudoUsuarioService conteudoUsuarioService;

    @RequestMapping("/seguir/{id}")
    public String seguirTurma(@PathVariable("id") Long id, Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        try {
            ConteudoUsuario conteudoUsuario = conteudoUsuarioService.seguir( id, usuario.getIdUsuario() );

        } catch (EnumConstantNotPresentException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }

    @RequestMapping("/deixar/seguir/{id}")
    public String deixarSeguirTurma(@PathVariable("id") Long id, Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        try {
            conteudoUsuarioService.deixarSeguir(id, usuario.getIdUsuario());

        } catch (OperacaoInvalidaException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }
}
