package br.com.monalisa.controller;


import br.com.monalisa.exception.OperacaoInvalidaException;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.TurmaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

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

    @PostMapping("/deixar-seguir")
    public String deixarSeguirTurma(HttpSession httpSession, Long idTurma) {
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        try {
            turmaUsuarioService.deixarSeguirTurma(usuario.getIdUsuario(), idTurma);

            return "minhas-turmas";
        } catch (OperacaoInvalidaException e) {
            e.printStackTrace();
        }

        return "/feed";
    }

}
