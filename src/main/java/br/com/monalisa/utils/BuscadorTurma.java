package br.com.monalisa.utils;

import br.com.framework.model.Conteudo;
import br.com.framework.repository.ConteudoRepository;
import br.com.framework.utils.BuscadorConteudo;
import br.com.monalisa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BuscadorTurma extends BuscadorConteudo {

    @Autowired
    private ConteudoRepository conteudoRepository;

    @Override
    public List<Conteudo> buscar(String palavraBusca) {
        Set<Conteudo> conteudos = new HashSet<>(conteudoRepository.buscarConteudoPorNome(palavraBusca));
        conteudos.addAll(conteudoRepository.buscarConteudoPorTopico(palavraBusca));
        conteudos.addAll(conteudoRepository.buscarConteudoPorTag(palavraBusca));

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
