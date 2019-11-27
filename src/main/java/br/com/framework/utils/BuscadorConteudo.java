package br.com.framework.utils;

import br.com.framework.model.Conteudo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class BuscadorConteudo {

    public List<Conteudo> execute(String palavraBusca){
        List<Conteudo> conteudos = buscar(palavraBusca);
        conteudos = filtrar(conteudos);
        conteudos = ordenar(conteudos);

        return conteudos;
    }

    public abstract List<Conteudo> buscar(String palavraBusca);

    public abstract  List<Conteudo> filtrar(List<Conteudo> conteudos);

    public abstract List<Conteudo> ordenar(List<Conteudo> conteudos);
}
