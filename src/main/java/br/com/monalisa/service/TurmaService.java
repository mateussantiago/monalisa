package br.com.monalisa.service;

import br.com.framework.service.ConteudoService;
import br.com.monalisa.utils.BuscadorTurma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService extends ConteudoService {
    @Autowired
    private BuscadorTurma buscadorConteudo;

    public TurmaService() {
        super();
    }

    public TurmaService(BuscadorTurma buscadorTurma) {
        super(buscadorTurma);
    }
}