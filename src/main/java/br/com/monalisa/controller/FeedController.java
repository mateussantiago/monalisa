package br.com.monalisa.controller;

import br.com.monalisa.framework.model.Conteudo;
import br.com.monalisa.framework.model.Usuario;
import br.com.monalisa.framework.service.ConteudoService;
import br.com.monalisa.framework.service.ConteudoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FeedController {

    @Autowired
    private ConteudoUsuarioService conteudoUsuarioService;

    @Autowired
    private ConteudoService conteudoService;

    @RequestMapping(value = "/buscar")
    public String buscar(@RequestParam(value = "palavraBusca", required = false) String palavraBusca, Model model, HttpSession httpSession) {
        try {
            Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
            List<Conteudo> conteudosEncontrados = conteudoService.buscarConteudos(palavraBusca);

            model.addAttribute("conteudosUsuario", conteudoUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
            model.addAttribute("conteudosEncontradosList", conteudosEncontrados);

            return "feed/buscar";

        } catch (Exception e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }
}
