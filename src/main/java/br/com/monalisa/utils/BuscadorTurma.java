package br.com.monalisa.utils;

import br.com.framework.model.Conteudo;
import br.com.framework.utils.BuscadorConteudo;
import br.com.monalisa.repository.TurmaRepository;
import br.com.monalisa.service.AssuntoTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BuscadorTurma extends BuscadorConteudo {
    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AssuntoTurmaService assuntoTurmaService;

    @Override
    public List<Conteudo> buscar(String palavraBusca) {
        Set<Conteudo> conteudos = new HashSet<>(turmaRepository.buscarTurmasPorNome(palavraBusca));
        conteudos.addAll(turmaRepository.buscarTurmaPorAssunto(palavraBusca));

        return new ArrayList<>(conteudos);
    }

    @Override
    public List<Conteudo> filtrar(List<Conteudo> conteudos) {
        return null;
    }

    @Override
    public List<Conteudo> orderar(List<Conteudo> conteudos) {
        return null;
    }
}
