package br.com.framework.utils;

import br.com.framework.model.Postagem;
import org.springframework.stereotype.Component;

@Component
public interface Punicao {
    public abstract void punir(Postagem postagem);
}
