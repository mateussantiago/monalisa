package br.com.monalisa.controller;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("")
    public String login(Model model) {
        return "login/login";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String registrar(Model model) {

        return "login/cadastro";
    }

    @RequestMapping(value = "/entrar", method = RequestMethod.POST)
    public String entrar(Model model, HttpSession httpSession) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioService.findByEmail(authentication.getPrincipal().toString());

        httpSession.setAttribute("usuarioLogado", usuario.getIdUsuario());

        return "redirect:/feed";
    }

    @RequestMapping(value = "/cadastro/novo", method = RequestMethod.POST)
    public String novoUsuario(UsuarioDTO usuarioDTO, Model model) {
        Usuario usuario = usuarioService.registrarUsuario(usuarioDTO);

        if (usuario != null ){
            return "redirect:/login";
        }

        return "redirect:/";
    }
}
