package br.com.monalisa.controller;

import br.com.monalisa.dto.UsuarioDTO;
import br.com.monalisa.framework.model.ConteudoUsuario;
import br.com.monalisa.framework.model.Usuario;
import br.com.monalisa.framework.service.ConteudoUsuarioService;
import br.com.monalisa.service.UsuarioMonalisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private UsuarioMonalisaService usuarioService;

    @Autowired
    private ConteudoUsuarioService conteudoUsuarioService;

    @RequestMapping("")
    public String login(@RequestParam(value = "error", required = false) Boolean error, Model model) {
        usuarioService.buscarPorEmail("mateus@gmail.com");
        conteudoUsuarioService.buscarPorIdUsuario(Long.valueOf(1));

        if (error != null && error)
            model.addAttribute("erroEntrar", "Usuário e/ou senha inválidos.");

        return "login/login";
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public String registrar(Model model) {

        return "login/cadastro";
    }

    @RequestMapping(value = "/entrar", method = RequestMethod.POST)
    public String entrar(Model model, HttpSession httpSession) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = usuarioService.buscarPorEmail(authentication.getPrincipal().toString());

        httpSession.setAttribute("usuarioLogado", usuario);

        return "redirect:/feed";
    }

    @RequestMapping(value = "/cadastro/novo", method = RequestMethod.POST)
    public String novoUsuario(UsuarioDTO usuarioDTO, Model model) {
        System.out.println("oiiiiiii");
        try {
            Usuario novoUsuario = usuarioService.registrarUsuario(usuarioDTO);

            return "redirect:/login";
        }
        catch (Exception e) {
            model.addAttribute("erroCadastro",  e.getMessage());
        }

        return "login/cadastro";
    }
}
