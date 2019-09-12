package br.com.monalisa.controller;


import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;
import br.com.monalisa.model.Usuario;
import br.com.monalisa.service.TurmaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("turma")
public class TurmaController {
    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @PostMapping("/follow")
    public TurmaUsuario followTurma(HttpSession httpSession, Long idTurma){
        Long idUsuario = (Long) httpSession.getAttribute("idUsuario");

        return turmaUsuarioService.seguirTurma(idUsuario,idTurma);
    }

    @PostMapping("/unfollow")
    public TurmaUsuario unfollowTurma(HttpSession httpSession, Long idTurma){
        Long idUsuario = (Long) httpSession.getAttribute("idUsuario");

        return turmaUsuarioService.deixarSeguirTurma(idUsuario, idTurma);
    }
}
