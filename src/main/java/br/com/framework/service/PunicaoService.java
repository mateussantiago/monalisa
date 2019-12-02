package br.com.framework.service;

import br.com.framework.model.Postagem;
import br.com.framework.utils.Punicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PunicaoService {
    @Autowired
    private Punicao punicao;

    public PunicaoService(){
        this(null);
    }

    public PunicaoService(Punicao punicao){
        this.punicao = punicao;
    }

    public void punir(Postagem postagem){
        punicao.punir(postagem);
    }
}
