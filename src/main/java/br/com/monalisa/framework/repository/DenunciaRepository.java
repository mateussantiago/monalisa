package br.com.monalisa.framework.repository;

import br.com.monalisa.framework.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long>, JpaSpecificationExecutor<Denuncia> {



    @Query(value = "select distinct d.* from public.denuncia d " +
            "where d.id_postagem = :idPostagem " +
            "and d.ativo is true" +
            "and d.processada is false", nativeQuery = true)
    List<Denuncia> recuperarDenunciasPorIdPostagem(@Param(value = "idPostagem") Long idPostagem);
}
