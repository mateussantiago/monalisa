package br.com.monalisa.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/entrar")
    public String entrar(Model model, HttpSession httpSession) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        return "feed/feed";
    }

    @RequestMapping(value = "/deuruim")
    public String deuruim(Model model) {

        return "deuruim";
    }
}
