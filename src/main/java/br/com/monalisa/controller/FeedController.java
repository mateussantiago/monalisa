package br.com.monalisa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/feed")
public class FeedController {

    @RequestMapping("")
    public String feed(Model model, HttpSession httpSession) {
       String emailUsuarioLogado = (String) httpSession.getAttribute("usuarioLogado");
       
        return "feed/feed";
    }
}
