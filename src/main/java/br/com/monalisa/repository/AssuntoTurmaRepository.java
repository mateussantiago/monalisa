package br.com.monalisa.repository;

import br.com.monalisa.model.AssuntoTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuntoTurmaRepository extends JpaRepository<AssuntoTurma, Long>, JpaSpecificationExecutor<AssuntoTurma> {
    @Query(value = "select * from public.assunto_turma where ativo is true", nativeQuery = true)
    List<AssuntoTurma> buscarTodos();

    @Query(value = "select * from public.assunto_turma where id_assunto_turma = :id and ativo is true", nativeQuery = true)
    AssuntoTurma buscarPorId(@Param(value = "id") Long id);

    @Query(value = "select * " +
            "from public.assunto_turma " +
            "where id_assunto = :idAssunto and " +
            "id_turma = :idTurma and " +
            "ativo is true", nativeQuery = true)
    AssuntoTurma buscarPorAssuntoETurma(@Param(value = "idAssunto") Long assunto,
                                        @Param(value = "idTurma") Long turma);
}