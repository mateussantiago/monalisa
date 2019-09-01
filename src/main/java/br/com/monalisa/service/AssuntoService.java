package br.com.monalisa.service;

import br.com.monalisa.repository.AssuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuntoService {
    @Autowired
    private AssuntoRepository assuntoRepository;
}
