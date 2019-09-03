package br.com.monalisa.repository;

import br.com.monalisa.model.AssuntoTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuntoTurmaRepository   extends JpaRepository<AssuntoTurma, Long>, JpaSpecificationExecutor<AssuntoTurma> {
    AssuntoTurma findAssuntoTurmaByAssuntoAndTurma(Long assunto, Long turma);
}