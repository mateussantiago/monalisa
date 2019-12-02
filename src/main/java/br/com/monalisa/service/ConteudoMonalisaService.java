package br.com.monalisa.service;

import br.com.framework.service.ConteudoService;
import br.com.monalisa.utils.BuscadorMonalisa;
import org.springframework.stereotype.Service;

@Service
public class ConteudoMonalisaService extends ConteudoService {
    public ConteudoMonalisaService() {
        super();
    }

    public ConteudoMonalisaService(BuscadorMonalisa buscadorTurma) {
        super(buscadorTurma);
    }
}