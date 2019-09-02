package br.com.monalisa.controller;

import javax.servlet.http.HttpSession;
import java.util.List;

import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.service.TurmaService;
import br.com.monalisa.service.TurmaUsuarioService;
import br.com.monalisa.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @RequestMapping("")
    public String feed(Model model, HttpSession httpSession) {
        Long idUsuario = (Long) httpSession.getAttribute("usuarioLogado");
        List<TurmaUsuario> turmaUsuarioList = turmaUsuarioService.findByIdUsuario(idUsuario);
        model.addAttribute("turmasUsuarios", turmaUsuarioList);

        turmaUsuarioService.deixarSeguirTurma(Long.valueOf(3), idUsuario);

        return "feed/feed";
    }
}
