package br.com.monalisa.framework.service;

import br.com.monalisa.framework.exception.RetornoDeBuscaVazioException;
import br.com.monalisa.framework.model.Conteudo;
import br.com.monalisa.framework.repository.ConteudoRepository;
import br.com.monalisa.framework.utils.BuscadorConteudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConteudoService {
    @Autowired
    private ConteudoRepository conteudoRepository;

    private BuscadorConteudo buscadorConteudo;

//    public List<Conteudo> buscarTodos() {
//        return conteudoRepository.buscarTodos();
//    }

//    public Conteudo buscarPorId(Long id) {
//        return conteudoRepository.buscarPorId(id);
//    }

    public Conteudo salvar(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    public List<Conteudo> buscarConteudos(String busca, Long idUsuario) {
        List<Conteudo> conteudosEncontrados = buscadorConteudo.execute(busca);

        if (conteudosEncontrados.isEmpty())
            throw new RetornoDeBuscaVazioException("Nenhum conteudo foi achado com o parâmetro de busca passado!");

        return conteudosEncontrados;
    }
}
