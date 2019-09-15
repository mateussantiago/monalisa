package br.com.monalisa.controller;

import br.com.monalisa.service.TurmaService;
import br.com.monalisa.service.TurmaUsuarioService;
import br.com.monalisa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(Model model) {

        return "index";
    }
}
