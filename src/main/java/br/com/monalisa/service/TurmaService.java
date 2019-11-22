package br.com.monalisa.service;

import br.com.framework.service.ConteudoService;
import br.com.monalisa.utils.BuscadorTurma;
import org.springframework.stereotype.Service;

@Service
public class TurmaService extends ConteudoService {
    public TurmaService() {
        super();
    }

    public TurmaService(BuscadorTurma buscadorTurma) {
        super(buscadorTurma);
    }
}