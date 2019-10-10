package br.com.monalisa.service;

import br.com.monalisa.exception.RetornoDeBuscaVazioException;
import br.com.monalisa.model.Turma;
import br.com.monalisa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    public List<Turma> buscarTodos() {
        return turmaRepository.buscarTodos();
    }

    public Turma buscarPorId(Long id) {
        return turmaRepository.buscarPorId(id);
    }

    public List<Turma> buscarPorNome(String nome, Long idUsuario) {
        return turmaRepository.buscarPorNome(nome,idUsuario);
    }

    public Turma salvar(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> buscarTurmasPorAssunto(String assunto, Long idUsuario) {
        return turmaRepository.buscarTurmasPorAssunto(assunto, idUsuario);
    }

    public List<Turma> buscarTurmasPorTag(String tag, Long idUsuario) {
        return turmaRepository.buscarTurmasPorTag(tag, idUsuario);
    }

    public List<Turma> buscarTurmas(String busca, Long idUsuario) {
        List<Turma> turmasEncontradasPorTags = buscarTurmasPorTag(busca, idUsuario);
        List<Turma> turmasEncontradasPorAssunto = buscarTurmasPorAssunto(busca, idUsuario);
        List<Turma> turmasEncontradasPorNome = buscarPorNome(busca, idUsuario);

        List<Turma> turmasEncontradas = turmasEncontradasPorTags;
        turmasEncontradas.addAll(turmasEncontradasPorAssunto);
        turmasEncontradas.addAll(turmasEncontradasPorNome);

        if (turmasEncontradas.isEmpty())
            throw new RetornoDeBuscaVazioException("Nenhuma turma foi achada com o parâmetro de busca passado!");

        return turmasEncontradas;
    }
}
