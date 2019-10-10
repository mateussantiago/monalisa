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

	@Query(value = "select t.* from turma t " +
			"where t.id_turma not in ( " +
			"select t.id_turma from turma t " +
			"join turma_usuario tu on tu.id_turma = t.id_turma " +
			"where tu.id_usuario = :idUsuario) " +
			"and lower(t.nome) like concat('%', lower(cast(:nome as text)), '%');", nativeQuery = true)
	List<Turma> buscarPorNome(@Param(value = "nome") String nome, @Param(value = "idUsuario") Long idUsuario);

	@Query(value = "select t.* from turma t " +
			"join tag_turma tt on tt.id_turma = t.id_turma " +
			"join tag ta on ta.id_tag = tt.id_tag " +
			"where t.id_turma not in ( " +
			"	select t.id_turma from turma t " +
			"	join turma_usuario tu on tu.id_turma = t.id_turma " +
			"	where tu.id_usuario = :idUsuario) " +
			"and lower(ta.nome) like concat('%', lower(cast(:tag as text)), '%');", nativeQuery = true)
	List<Turma> buscarTurmasPorTag(@Param(value = "tag") String tag, @Param("idUsuario") Long idUsuario);

	@Query(value = "select t.* from turma t " +
			"join assunto_turma ast on ast.id_turma = t.id_turma " +
			"join assunto a on a.id_assunto = ast.id_assunto " +
			"where t.id_turma not in ( " +
			"	select t.id_turma from turma t " +
			"	join turma_usuario tu on tu.id_turma = t.id_turma " +
			"	where tu.id_usuario = :idUsuario) " +
			"and lower(a.nome) like concat('%', lower(cast(:assunto as text)), '%');", nativeQuery = true)
	List<Turma> buscarTurmasPorAssunto(@Param(value = "assunto") String assunto, @Param(value = "idUsuario") Long idUsuario);
}