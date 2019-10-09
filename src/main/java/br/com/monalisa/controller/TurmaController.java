package br.com.monalisa.controller;


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

    @PostMapping("/seguir")
    public TurmaUsuario seguirTurma(HttpSession httpSession, Long idTurma){
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        return turmaUsuarioService.seguirTurma(usuario.getIdUsuario(), idTurma);
    }

    @PostMapping("/desseguir")
    public TurmaUsuario desseguirTurma(HttpSession httpSession, Long idTurma){
        Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

        return turmaUsuarioService.deixarSeguirTurma(usuario.getIdUsuario(), idTurma);
    }
}
