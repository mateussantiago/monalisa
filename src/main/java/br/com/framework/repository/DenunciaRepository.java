package br.com.framework.repository;

import br.com.framework.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long>, JpaSpecificationExecutor<Denuncia> {

    @Query(value = "select distinct d.* from public.denuncia d " +
            "where d.id_postagem = :idPostagem " +
            "and d.ativo is true" +
            "and d.processada is false", nativeQuery = true)
    List<Denuncia> recuperarDenunciasPorIdPostagem(@Param(value = "idPostagem") Long idPostagem);
}
