package br.com.serie;

import br.com.framework.model.Postagem;
import br.com.framework.utils.ComparadorPostagem;

public class ComparadorSerie implements ComparadorPostagem {

    @Override
    public int compare(Postagem o1, Postagem o2) {
        if (o1.getCurtidasPositivas() < o2.getCurtidasPositivas())
            return -1;
        else if (o1.getCurtidasPositivas() > o2.getCurtidasPositivas())
            return 1;

        return 0;
    }
}
