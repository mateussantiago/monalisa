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
    @Query(value = "select * from assunto_turma ast" +
            "where", nativeQuery = true)
    List<AssuntoTurma> buscarTodos();

    @Query(value = "select * from assunto_turma " +
            "where id_assunto_turma = :id " +
            "and ativo is true", nativeQuery = true)
    AssuntoTurma buscarPorId(@Param(value = "id") Long id);

    @Query(value = "select * " +
            "from assunto_turma " +
            "where id_assunto = :idAssunto and " +
            "id_turma = :idTurma and " +
            "ativo is true", nativeQuery = true)
    AssuntoTurma buscarPorAssuntoETurma(@Param(value = "idAssunto") Long assunto, @Param(value = "idTurma") Long turma);

    @Query(value = "select * from assunto_turma " +
            "where id_turma = :idTurma " +
            "and ativo is true", nativeQuery = true)
    List<AssuntoTurma> buscarPorIdTurma(@Param(value = "idTurma") Long idTurma);

    @Query(value = "select ast.* from assunto_turma ast " +
            "join turma_usuario tu on tu.id_turma = ast.id_turma " +
            "join turma t on t.id_turma = tu.id_turma " +
            "where ast.ativo is true " +
            "and tu.ativo is true " +
            "and tu.id_usuario = :idUsuario " +
            "order by t.nome asc", nativeQuery = true)
    List<AssuntoTurma> buscaPorIdUsuario(@Param(value = "idUsuario") Long idUsuario);
}