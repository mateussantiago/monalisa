package br.com.monalisa.service;

import br.com.framework.service.PunicaoService;
import br.com.monalisa.utils.PunicaoMonalisa;
import org.springframework.stereotype.Service;

@Service
public class PunicaoMonalisaService extends PunicaoService {
    public PunicaoMonalisaService(){
        super();
    }

    public PunicaoMonalisaService(PunicaoMonalisa punicaoMonalisa){
        super(punicaoMonalisa);
    }
}
