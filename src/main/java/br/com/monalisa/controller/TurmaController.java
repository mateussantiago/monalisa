package br.com.monalisa.controller;


import br.com.monalisa.exception.OperacaoInvalidaException;
import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.TurmaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @RequestMapping("/seguir")
    public String seguirTurma(HttpSession httpSession, Long idTurma){
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        try {
            TurmaUsuario turmaUsuario = turmaUsuarioService.seguirTurma(usuario.getIdUsuario(), idTurma);

            return "/feed";
        }
        catch (EnumConstantNotPresentException e) {
            e.printStackTrace();
        }

        return "/buscar-turmas";
    }

    @PostMapping("/deixar-seguir")
    public String deixarSeguirTurma(HttpSession httpSession, Long idTurma){
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        try {
            turmaUsuarioService.deixarSeguirTurma(usuario.getIdUsuario(), idTurma);

            return "minhas-turmas";
        }
        catch (OperacaoInvalidaException e) {
            e.printStackTrace();
        }

        return "/feed";
    }

}
