package br.com.monalisa.controller;

import br.com.monalisa.model.*;
import br.com.monalisa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("feed")
public class FeedController {

    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @Autowired
    private TagTurmaService tagTurmaService;

    @Autowired
    private AssuntoService assuntoService;

    @Autowired
    private AssuntoTurmaService assuntoTurmaService;

    @Autowired
    private PostagemService postagemService;

    @RequestMapping("")
    public String feed(Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
        model.addAttribute("postagemList", postagemService.buscarPostagensPrincipais(usuario));

        return "feed/feed";
    }

    @RequestMapping(value = "/turma/{idTurma}")
    public String turma(@PathVariable("idTurma") Long idTurma, Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
        model.addAttribute("postagemList", postagemService.buscarPostagensPorTurma(idTurma));

        return "feed/feed";
    }

    @RequestMapping(value = "/turma/{idTurma}/assunto/{idAssunto}")
    public String assuntoPostagens(@PathVariable("idTurma") Long idTurma, @PathVariable("idAssunto") Long idAssunto, Model model,
                                   HttpSession httpSession) {
        return "";
    }

    @PostMapping(value = "/buscar")
    public String buscar(Model model, String busca){
        List<Turma> turmasEncontradas = tagTurmaService.buscarTurmasPorTag(busca);
        List<Assunto> assuntosEncontrados = assuntoService.buscarAssuntoPorNome(busca);

        model.addAttribute("turmasEncontradasList", turmasEncontradas);
        model.addAttribute("assuntosEncontradisList", assuntosEncontrados);

        return "feed/feed";
    }
}
