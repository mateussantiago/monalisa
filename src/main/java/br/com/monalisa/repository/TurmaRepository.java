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
	@Query(value = "select * from public.turma where ativo is true", nativeQuery = true)
	List<Turma> buscarTodos();

	@Query(value = "select * from public.turma where id_turma = :id and ativo is true", nativeQuery = true)
	Turma buscarPorId(@Param(value = "id") Long id);
}