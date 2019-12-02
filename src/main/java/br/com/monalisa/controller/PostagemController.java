package br.com.monalisa.controller;

import br.com.framework.model.Postagem;
import br.com.framework.model.Topico;
import br.com.framework.model.Usuario;
import br.com.framework.service.DenunciaService;
import br.com.framework.service.PostagemService;
import br.com.monalisa.dto.PostagemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("postagem")
public class PostagemController {
    @Autowired
    private PostagemService postagemService;

    @Autowired
    private DenunciaService denunciaService;

    @RequestMapping(value = "/postar", method = RequestMethod.POST)
    public String postar(Model model, HttpSession httpSession, PostagemDTO postagemDTO){
        try {
            Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");
            Postagem postagem = new Postagem();
            Postagem postagemGenitora = new Postagem();
            Topico topico = new Topico();
            topico.setIdTopico(postagemDTO.getIdTopico());
            postagem.setTopico(topico);
            postagem.setTexto(postagemDTO.getTexto());

            if (postagemDTO.getIdPostagemGenitora() != null)
                postagemGenitora.setIdPostagem(postagemDTO.getIdPostagemGenitora());

            postagem.setPostagemGenitora(postagemGenitora);
            postagem = postagemService.postar(postagem, usuario);
        }
        catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("erro", e.getMessage());
        }
        return "redirect:/feed";
    }

    @RequestMapping(value = "/{id}/gostar")
    public String gostar(Model model, @PathVariable(value = "id") Long id){
        try {
            Postagem postagem = postagemService.gostar(id);

        } catch (EnumConstantNotPresentException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }

    @RequestMapping(value = "/{id}/desgostar")
    public String desgostar(Model model, @PathVariable(value = "id") Long id){
        try {
            Postagem postagem = postagemService.desgostar(id);

        } catch (EnumConstantNotPresentException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }

    @RequestMapping(value = "/{id}/denunciar")
    public String denunciar(@PathVariable(value = "id") Long id, String motivacao, HttpSession httpSession, Model model){
        try {
            Usuario usuario = (Usuario) httpSession.getAttribute("usuarioLogado");

           denunciaService.denunciar(id, motivacao, usuario);

        } catch (EnumConstantNotPresentException e) {
            model.addAttribute("erro", e.getMessage());
        }

        return "redirect:/feed";
    }
}
