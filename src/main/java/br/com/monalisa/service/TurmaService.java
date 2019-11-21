package br.com.monalisa.service;

import br.com.monalisa.framework.model.Conteudo;
import br.com.monalisa.framework.repository.ConteudoRepository;
import br.com.monalisa.framework.service.ConteudoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService extends ConteudoService {
    @Autowired
    private ConteudoRepository conteudoRepository;

//    private BuscadorTurma buscadorConteudo;
}