package br.com.monalisa.controller;

import br.com.monalisa.model.Assunto;
import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.service.AssuntoService;
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

    @RequestMapping("")
    public String feed(Model model, HttpSession httpSession) {
        Long idUsuario = (Long) httpSession.getAttribute("usuarioLogado");
        List<TurmaUsuario> turmaUsuarioList = turmaUsuarioService.buscarPorIdUsuario(idUsuario);
        model.addAttribute("turmaUsuarioList", turmaUsuarioList);

        return "feed/feed";
    }

    @RequestMapping(value = "/turma/{idTurma}")
    public String turma(@PathVariable("idTurma") Long idTurma, Model model) {
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
