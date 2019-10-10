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
}
