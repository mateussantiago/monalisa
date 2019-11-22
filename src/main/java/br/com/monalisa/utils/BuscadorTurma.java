package br.com.monalisa.utils;

import br.com.framework.model.Conteudo;
import br.com.framework.utils.BuscadorConteudo;
import br.com.monalisa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BuscadorTurma extends BuscadorConteudo {
    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    public List<Conteudo> buscar(String palavraBusca) {
        Set<Conteudo> conteudos = new HashSet<>(turmaRepository.buscarTurmasPorNome(palavraBusca));
        conteudos.addAll(turmaRepository.buscarTurmaPorAssunto(palavraBusca));
        conteudos.addAll(turmaRepository.buscarTurmasPorTag(palavraBusca));

        return new ArrayList<>(conteudos);
    }

    @Override
    public List<Conteudo> filtrar(List<Conteudo> conteudos) {
        conteudos.removeIf(conteudo -> conteudo.getAtivo().equals(false));
        return conteudos;
    }

    @Override
    public List<Conteudo> orderar(List<Conteudo> conteudos) {
        conteudos.sort((t1, t2) -> {
            if (t1.getIdConteudo() > t2.getIdConteudo()){
                return 1;
            }
            else if(t1.getIdConteudo() < t2.getIdConteudo()){
                return -1;
            }
            return 0;
        });
        return conteudos;
    }
}
