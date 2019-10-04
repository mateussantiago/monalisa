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
    @Query(value = "select * from assunto where ativo is true", nativeQuery = true)
    List<Assunto> buscarTodos();

    @Query(value = "select * from assunto where id_assunto = :id and ativo is true", nativeQuery = true)
    Assunto buscarPorId(@Param(value = "id") Long id);

    @Query(value = "select * " +
            "from assunto " +
            "where lower(nome) like concat('%', lower(cast(:assunto as text)), '%')" +
            "and ativo is true", nativeQuery = true)
    List<Assunto> buscarAssuntoPorNome(@Param(value = "assunto") String assunto);

    @Query(value = "select * " +
            "from assunto " +
            "where nome = assunto" +
            "and ativo is true", nativeQuery = true)
    Assunto buscarAssuntoPorNomeExato(@Param(value = "assunto") String assunto);

    @Query(value = "select * from assunto where id_usuario = :id", nativeQuery = true)
    List<Assunto> buscarPorIdUsuario(@Param(value = "id") Long id);
}
