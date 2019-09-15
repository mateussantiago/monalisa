package br.com.monalisa.controller;

import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.service.TurmaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("feed")
public class FeedController {

    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

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
}
