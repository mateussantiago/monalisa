package br.com.monalisa.controller;

import br.com.monalisa.model.Postagem;
import br.com.monalisa.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("postagem")
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

//    @PostMapping("/")
//    public Postagem postar(@RequestBody Postagem postagem){
//        postagemService.save(postagem);
//    }


}
