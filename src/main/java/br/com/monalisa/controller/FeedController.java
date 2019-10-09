package br.com.monalisa.controller;

import br.com.monalisa.model.Assunto;
import br.com.monalisa.model.Turma;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    private TurmaService turmaService;

    @RequestMapping("")
    public String feed(Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
        model.addAttribute("postagemList", postagemService.buscarPostagensPrincipais(usuario));
        model.addAttribute("assuntoTurmasList", assuntoTurmaService.buscaPorIdUsuario(usuario.getIdUsuario()));

        return "feed/feed";
    }

    @RequestMapping(value = "/turma/{idTurma}")
    public String turma(@PathVariable("idTurma") Long idTurma, Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
        model.addAttribute("postagemList", postagemService.buscarPostagensPorTurma(idTurma));
        model.addAttribute("assuntoTurmasList", assuntoTurmaService.buscarPorIdTurma(idTurma));

        return "feed/feed";
    }

    @RequestMapping(value = "/turma/{idTurma}/assunto/{idAssunto}")
    public String assuntoPostagens(@PathVariable("idTurma") Long idTurma, @PathVariable("idAssunto") Long idAssunto, Model model,
                                   HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));
        model.addAttribute("postagemList", postagemService.buscarPostagensPorTurmaEAssunto(idTurma, idAssunto));
        model.addAttribute("assuntoTurma", assuntoTurmaService.buscarPorIdAssuntoEIdTurma(idAssunto, idTurma));

        return "feed/feed";
    }

        List<Turma> turmasEncontradasPorAssunto = turmaService.buscarTurmasPorAssunto(busca);
    @RequestMapping(value = "/buscar")
    public String buscar(@RequestParam(value = "buscarPor", required = false) String buscarPor, Model model, String busca){
        List<Turma> turmasEncontradasPorNome = turmaService.buscarPorNome(busca);
        List<Turma> turmasEncontradasPorTags = turmaService.buscarTurmasPorTag(busca);

        List<Turma> turmasEncontradas = turmasEncontradasPorTags;
        turmasEncontradas.addAll(turmasEncontradasPorAssunto);
        turmasEncontradas.addAll(turmasEncontradasPorNome);


        model.addAttribute("turmasEncontradasList", turmasEncontradas);

        return "re";
    }
}
