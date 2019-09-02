package br.com.monalisa.repository;

import java.util.List;

import br.com.monalisa.model.Turma;
import br.com.monalisa.model.TurmaUsuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaUsuarioRepository extends JpaRepository<TurmaUsuario, Long>, JpaSpecificationExecutor<TurmaUsuario> {

	@Query(value = "select * from turma_usuario tu " +
			"where tu.id_usuario = :idUsuario " +
			"and tu.ativo is true", nativeQuery = true)
	List<TurmaUsuario> findByIdUsuario(Long idUsuario);

	@Query(value = "select * from turma_usuario tu " +
			"where tu.id_turma = :idTurma " +
			"and tu.id_usuario = :idUsuario ", nativeQuery = true)
	TurmaUsuario findByIdTurmaAndIdUsuario(Long idTurma, Long idUsuario);

}
