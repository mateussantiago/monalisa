package br.com.framework.service;

import br.com.framework.exception.EntidadeNaoEncontradaException;
import br.com.framework.exception.RetornoDeBuscaVazioException;
import br.com.framework.repository.ConteudoRepository;
import br.com.framework.model.Conteudo;
import br.com.framework.utils.BuscadorConteudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConteudoService {
    @Autowired
    private ConteudoRepository conteudoRepository;

    @Autowired
    private BuscadorConteudo buscadorConteudo;

    public ConteudoService() {
        this(null);
    }

    public ConteudoService(BuscadorConteudo buscadorConteudo) {
        this.buscadorConteudo = buscadorConteudo;
    }

    public List<Conteudo> buscarTodos() {
        return conteudoRepository.findAll();
    }

    public Conteudo buscarPorId(Long id) {
        Optional<Conteudo> conteudo = conteudoRepository.findById(id);

        if (!conteudo.isPresent()){
            throw new EntidadeNaoEncontradaException("Não foi possível localizar um conteúdo com este id.");
        }

        return conteudo.get();
    }

    public Conteudo salvar(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    public List<Conteudo> buscarConteudos(String busca) {
        List<Conteudo> conteudosEncontrados = buscadorConteudo.buscar(busca);

        if (conteudosEncontrados.isEmpty())
            throw new RetornoDeBuscaVazioException("Nenhum conteudo foi achado com o parâmetro de busca passado!");

        return conteudosEncontrados;
    }
}