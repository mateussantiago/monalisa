package br.com.monalisa.service;

import br.com.framework.model.Postagem;
import br.com.framework.model.Usuario;
import br.com.framework.service.PostagemService;
import br.com.framework.dto.PostagemDTO;
import br.com.monalisa.utils.ComparadorPostagemMonalisa;
import org.springframework.stereotype.Service;

@Service
public class PostagemMonalisaService extends PostagemService {
    public PostagemMonalisaService() {
        super();
    }

    public PostagemMonalisaService(ComparadorPostagemMonalisa comparadorPostagem) {
        super(comparadorPostagem);
    }
}
