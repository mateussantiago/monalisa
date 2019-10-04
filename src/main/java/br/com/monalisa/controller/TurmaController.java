package br.com.monalisa.controller;


import br.com.monalisa.dto.SugestaoAssuntoDTO;
import br.com.monalisa.model.*;
import br.com.monalisa.service.*;
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

    @Autowired AssuntoTurmaService assuntoTurmaService;

    @PostMapping("/seguir")
    public TurmaUsuario seguirTurma(HttpSession httpSession, Long idTurma){
        Long idUsuario = (Long) httpSession.getAttribute("usuarioLogado");

        return turmaUsuarioService.seguirTurma(idUsuario, idTurma);
    }

    @PostMapping("/desseguir")
    public TurmaUsuario desseguirTurma(HttpSession httpSession, Long idTurma){
        Long idUsuario = (Long) httpSession.getAttribute("usuarioLogado");

        return turmaUsuarioService.deixarSeguirTurma(idUsuario, idTurma);
    }

    @RequestMapping("/sugerir/assunto")
    public void sugerirAssunto(HttpSession httpSession, SugestaoAssuntoDTO sugestaoAssuntoDTO){
        Long idUsuario = (Long) httpSession.getAttribute("usuarioLogado");
        assuntoTurmaService.sugerirAssunto(sugestaoAssuntoDTO, idUsuario);


    }
}
