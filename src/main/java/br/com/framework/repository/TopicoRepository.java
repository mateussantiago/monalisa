package br.com.framework.repository;

import br.com.framework.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaSpecificationExecutor<Topico>, JpaRepository<Topico, Long> {
    @Query(value = "select t.* from public.topico t " +
            "join conteudo_usuario cu on cu.id_conteudo = t.id_conteudo " +
            "join conteudo c on c.id_conteudo = cu.id_conteudo " +
            "where t.ativo is true " +
            "and cu.ativo is true " +
            "and cu.id_usuario = :idUsuario " +
            "order by c.nome asc", nativeQuery = true)
    List<Topico> buscaPorIdUsuario(@Param(value = "idUsuario") Long idUsuario);
}
