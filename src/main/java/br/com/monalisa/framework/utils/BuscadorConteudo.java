package br.com.monalisa.framework.utils;

import br.com.monalisa.framework.model.Conteudo;

import java.util.List;

public abstract class BuscadorConteudo {

    public List<Conteudo> execute(String palavraBusca){
        List<Conteudo> conteudos = buscar(palavraBusca);
        conteudos = filtrar(conteudos);
        conteudos = orderar(conteudos);

        return conteudos;
    }

    public abstract List<Conteudo> buscar(String palavraBusca);

    public abstract  List<Conteudo> filtrar(List<Conteudo> conteudos);

    public abstract List<Conteudo> orderar(List<Conteudo> conteudos);
}
