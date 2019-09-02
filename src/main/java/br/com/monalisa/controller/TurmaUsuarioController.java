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

@Controller
@RequestMapping("turmausuario")
public class TurmaUsuarioController {
    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @PostMapping("/follow")
    public TurmaUsuario followTurma(@RequestBody Turma turma){
        Usuario usuario = new Usuario();
        return turmaUsuarioService.seguirTurma(usuario.getIdUsuario(), turma.getIdTurma());
    }

    @PostMapping("/unfollow")
    public TurmaUsuario unfollowTurma(@RequestBody Turma turma){
        Usuario usuario = new Usuario();
        return turmaUsuarioService.deixarSeguirTurma(usuario.getIdUsuario(), turma.getIdTurma());
    }
}
