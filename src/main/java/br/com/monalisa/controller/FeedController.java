package br.com.monalisa.controller;

import br.com.monalisa.model.*;
import br.com.monalisa.service.AssuntoService;
import br.com.monalisa.service.AssuntoTurmaService;
import br.com.monalisa.service.TagTurmaService;
import br.com.monalisa.service.TurmaUsuarioService;
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

    @RequestMapping("")
    public String feed(Model model, HttpSession httpSession) {
        // Long idUsuario = (Long) httpSession.getAttribute("usuarioLogado");
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
//        System.out.println(usuario.getNome());

        List<TurmaUsuario> turmaUsuarioList = turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario());

        if (turmaUsuarioList != null && !turmaUsuarioList.isEmpty()) {
            Turma primeiraTurma = turmaUsuarioList.get(0).getTurma();
            List<AssuntoTurma> assuntoTurmaList = assuntoTurmaService.buscarPorIdTurma( primeiraTurma.getIdTurma());
            model.addAttribute("assuntoTurmaList", assuntoTurmaList);
        }

        model.addAttribute("turmaUsuarioList", turmaUsuarioList);

        return "feed/feed";
    }

    @RequestMapping(value = "/turma/{idTurma}")
    public String turma(@PathVariable("idTurma") Long idTurma, Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
        List<TurmaUsuario> turmaUsuarioList = turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario());
        List<AssuntoTurma> assuntoTurmaList = assuntoTurmaService.buscarPorIdTurma(idTurma);
        model.addAttribute("turmaUsuarioList", turmaUsuarioList);
        model.addAttribute("assuntoTurmaList", assuntoTurmaList);

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
