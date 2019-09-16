package br.com.monalisa.repository;

import java.util.List;

import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaUsuarioRepository extends JpaRepository<TurmaUsuario, Long>, JpaSpecificationExecutor<TurmaUsuario> {
	@Query(value = "select * from public.turma_usuario " +
			"where id_usuario = :idUsuario " +
			"and ativo is true", nativeQuery = true)
	List<TurmaUsuario> buscarPorIdUsuario(@Param(value = "idUsuario") Long idUsuario);

	@Query(value = "select * from public.turma_usuario " +
			"where id_turma = :idTurma " +
			"and id_usuario = :idUsuario ", nativeQuery = true)
	TurmaUsuario buscarPorIdTurmaEIdUsuario(@Param("idTurma") Long idTurma,
											@Param(value = "idUsuario") Long idUsuario);

}
