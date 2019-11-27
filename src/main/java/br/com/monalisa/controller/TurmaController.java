package br.com.monalisa.controller;

import br.com.framework.model.Usuario;
import br.com.monalisa.service.TurmaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("turma")
public class TurmaController extends ConteudoController {
    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @RequestMapping("")
    public String gerenciarTurmas(Model model, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));

        return "turmas/turmas";
    }
}
