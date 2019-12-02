package br.com.framework.repository;

import br.com.framework.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Repository
public interface DenunciaRepository extends JpaRepository<Denuncia, Long>, JpaSpecificationExecutor<Denuncia> {

    @Query(value = "select distinct d.* from public.denuncia d " +
            "where d.id_postagem = :idPostagem " +
            "and d.ativo is true" +
            "and d.processada is false", nativeQuery = true)
    List<Denuncia> recuperarDenunciasPorIdPostagem(@Param(value = "idPostagem") Long idPostagem);

    @Query("select distinct d from Denuncia d where d.tipoDenuncia = :tipo and d.postagem.idPostagem = :postagem and d.processada = false")
    List<Denuncia> buscarDenunciasPorTipo(@Param("postagem") Long idPostagem,
                                                @Param("tipo") String tipo);
}
