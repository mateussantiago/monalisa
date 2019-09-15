package br.com.monalisa.repository;

import br.com.monalisa.model.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssuntoRepository  extends JpaRepository<Assunto, Long>, JpaSpecificationExecutor<Assunto> {
    @Query(value = "select * from public.assunto where ativo is true", nativeQuery = true)
    List<Assunto> buscarTodos();

    @Query(value = "select * from public.assunto where id_assunto = :id and ativo is true", nativeQuery = true)
    Assunto buscarPorId(@Param(value = "id") Long id);
}
