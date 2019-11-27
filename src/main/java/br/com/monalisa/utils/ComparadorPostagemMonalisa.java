package br.com.monalisa.utils;

import br.com.framework.model.Postagem;
import br.com.framework.utils.ComparadorPostagem;
import org.springframework.stereotype.Component;

@Component
public class ComparadorPostagemMonalisa implements ComparadorPostagem {
    @Override
    public int compare(Postagem postagem, Postagem t1) {
        return 0;
    }
}
