package br.com.monalisa.service;

import br.com.monalisa.exception.EntidadeNaoEncontradaException;
import br.com.monalisa.exception.RetornoDeBuscaVazioException;
import br.com.monalisa.model.Turma;
import br.com.monalisa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService  {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> buscarTodos() {
        return turmaRepository.buscarTodos();
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.buscarPorId(id);
    }

    public List<Turma> buscarPorNome(String nome) {
        return turmaRepository.buscarPorNome(nome);
    }

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> buscarTurmasPorAssunto(String assunto){
        return turmaRepository.buscarTurmasPorAssunto(assunto);
    }

    public List<Turma> buscarTurmasPorTag(String tag){
        return turmaRepository.buscarTurmasPorTag(tag);
    }

    public List<Turma> buscarTurmas(String busca){
        List<Turma> turmasEncontradasPorTags = buscarTurmasPorTag(busca);
        List<Turma> turmasEncontradasPorAssunto = buscarTurmasPorAssunto(busca);
        List<Turma> turmasEncontradasPorNome = buscarPorNome(busca);

        List<Turma> turmasEncontradas = turmasEncontradasPorTags;
        turmasEncontradas.addAll(turmasEncontradasPorAssunto);
        turmasEncontradas.addAll(turmasEncontradasPorNome);

        if(turmasEncontradas.isEmpty()){
            throw new RetornoDeBuscaVazioException("Nenhuma turma foi achada com o parâmetro de busca passado!");
        }else{
            return turmasEncontradas;
        }
    }
}
