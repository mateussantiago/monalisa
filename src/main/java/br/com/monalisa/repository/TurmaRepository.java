package br.com.monalisa.repository;

import br.com.monalisa.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>, JpaSpecificationExecutor<Turma> {
	@Query(value = "select * from turma where ativo is true", nativeQuery = true)
	List<Turma> buscarTodos();

	@Query(value = "select * from turma where id_turma = :id and ativo is true", nativeQuery = true)
	Turma buscarPorId(@Param(value = "id") Long id);

	@Query(value = "select * from turma " +
			       "where lower(nome) like concat('%', lower(cast(:nome as text)), '%') " +
			       "and ativo is true", nativeQuery = true)
	List<Turma> buscarPorNome(@Param(value = "nome") String nome);

	@Query(value = "select t.* from turma as t " +
			"join tag_turma tt on tt.id_turma = t.id_turma " +
			"join tag ta on tt.id_tag = ta.id_tag " +
			"where t.ativo is true " +
			"and tt.ativo is true " +
			"and ta.ativo is true " +
			"and lower(ta.nome) like concat('%', lower(cast(:tag as text)), '%');", nativeQuery = true)
	List<Turma> buscarTurmasPorTag(@Param(value = "tag") String tag);

	@Query(value = "select t.* from turma as t " +
			"join assunto_turma at on at.id_turma = t.id_turma " +
			"join assunto a on a.id_assunto = at.id_assunto " +
			"where t.ativo is true " +
			"and at.ativo is true " +
			"and a.ativo is true " +
			"and lower(a.nome) like concat('%', lower(cast(:assunto as text)), '%');", nativeQuery = true)
	List<Turma> buscarTurmasPorAssunto(@Param(value = "assunto") String assunto);
}