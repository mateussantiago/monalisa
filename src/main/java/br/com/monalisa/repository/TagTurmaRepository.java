package br.com.monalisa.repository;

import br.com.monalisa.model.TagTurma;
import br.com.monalisa.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagTurmaRepository extends JpaRepository<TagTurma, Long>, JpaSpecificationExecutor<TagTurma> {
    @Query(value = "select * from tag_turma where ativo is true", nativeQuery = true)
    List<TagTurma> buscarTodos();

    @Query(value = "select * from tag_turma where id_tag_turma = :id and ativo is true", nativeQuery = true)
    TagTurma buscarPorId(@Param(value = "id") Long id);

    @Query(value = "select t.* " +
            "from tag as tg, tag_turma as tt, turma as t" +
            "where t.id_turma =  tt.id_turma " +
            "and tt.id_tag = tg.id_tag " +
            "and lower(tg.nome) like concat('%', lower(cast(:tag as text)), '%')" +
            "and tt.ativo is true " +
            "and t.ativo is true " +
            "and tg.ativo is true", nativeQuery = true)
    List<Turma> buscarTurmaPorTag(@Param(value = "tag") String tag);
}
