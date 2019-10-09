package br.com.monalisa.repository;

import br.com.monalisa.model.TurmaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaUsuarioRepository extends JpaRepository<TurmaUsuario, Long>, JpaSpecificationExecutor<TurmaUsuario> {

	@Query(value = "select distinct tu.* from public.turma_usuario tu " +
			"where tu.id_usuario = :idUsuario " +
			"and tu.ativo is true", nativeQuery = true)
	List<TurmaUsuario> buscarPorIdUsuario(@Param(value = "idUsuario") Long idUsuario);

	@Query(value = "select * from public.turma_usuario " +
			"where id_turma = :idTurma " +
			"and id_usuario = :idUsuario ", nativeQuery = true)
	TurmaUsuario buscarPorIdTurmaEIdUsuario(@Param("idTurma") Long idTurma, @Param(value = "idUsuario") Long idUsuario);

}
