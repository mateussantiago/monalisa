package br.com.monalisa.controller;

import br.com.monalisa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping("/")
    public String index() {

        return "Iai, ray ray.";
    }
}
