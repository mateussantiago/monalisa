package br.com.monalisa.controller;

import br.com.framework.model.Conteudo;
import br.com.framework.model.Usuario;
import br.com.framework.service.ConteudoService;
import br.com.framework.service.ConteudoTopicoService;
import br.com.framework.service.ConteudoUsuarioService;
import br.com.framework.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("feed")
public class FeedController {

    @Autowired
    private ConteudoService conteudoService;

    @Autowired
    private ConteudoUsuarioService conteudoUsuarioService;
    
    @Autowired
    private ConteudoTopicoService conteudoTopicoService;

    @Autowired
    private  PostagemService postagemService;


    @RequestMapping("")
    public String feed(Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", conteudoUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
        model.addAttribute("postagemList", postagemService.buscarPostagensPrincipais(usuario));
        model.addAttribute("assuntoTurmaList", conteudoTopicoService.buscarPorIdUsuario(usuario.getIdUsuario()));

        return "feed/feed";
    }

    @RequestMapping(value = "/buscar")
    public String buscar(@RequestParam(value = "palavraBusca", required = false) String palavraBusca, Model model, HttpSession httpSession) {
        try {
            Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

            List<Conteudo> conteudosEncontrados = conteudoService.buscarConteudos(palavraBusca);
            model.addAttribute("conteudosUsuario", conteudoUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
            model.addAttribute("conteudosEncontradosList", conteudosEncontrados);

            return "feed/buscar";

        } catch (Exception e) {
            e.printStackTrace();

            model.addAttribute("erro", e.getMessage());

            return "redirect:/feed";
        }
    }

    @RequestMapping(value = "/turma/{idTurma}/assunto/{idAssunto}")
    public String topicoPostagens(@PathVariable("idTurma") Long idTurma, @PathVariable("idAssunto") Long idAssunto,
                                  Model model, HttpSession httpSession) {

        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", conteudoUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
        model.addAttribute("postagemList", postagemService.buscarPostagensPorConteudoETopico(idTurma, idAssunto));
        //model.addAttribute("assuntoTurma", assuntoTurmaService.buscarPorIdAssuntoEIdTurma(idAssunto, idTurma));

        return "feed/feed";
    }

}
