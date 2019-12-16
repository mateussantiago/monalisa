package br.com.monalisa.controller;


import br.com.monalisa.exception.OperacaoInvalidaException;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.TurmaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @RequestMapping("")
    public String gerenciarTurmas(Model model, HttpSession httpSession){
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        model.addAttribute("turmaUsuarioList", turmaUsuarioService.buscarPorIdUsuario(usuario.getIdUsuario()));

        return "turmas/turmas";
    }

    @RequestMapping("/seguir/{idTurma}")
    public String seguirTurma(@PathVariable("idTurma") Long idTurma, Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        try {
            TurmaUsuario turmaUsuario = turmaUsuarioService.seguirTurma(idTurma, usuario.getIdUsuario());

        } catch (EnumConstantNotPresentException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }

    @RequestMapping("/deixar-de-seguir/{idTurma}")
    public String deixarSeguirTurma(@PathVariable("idTurma") Long idTurma, Model model, HttpSession httpSession) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        try {
            turmaUsuarioService.deixarSeguirTurma(idTurma, usuario.getIdUsuario());

        } catch (OperacaoInvalidaException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }

}
