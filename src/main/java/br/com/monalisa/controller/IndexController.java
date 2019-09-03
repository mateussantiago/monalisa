package br.com.monalisa.controller;

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
public class IndexController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private TurmaUsuarioService turmaUsuarioService;

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String index(Model model) {

        return "index";
    }
}
