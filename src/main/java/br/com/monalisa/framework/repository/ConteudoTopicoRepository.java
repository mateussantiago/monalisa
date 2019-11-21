package br.com.monalisa.framework.repository;

import br.com.monalisa.framework.model.ConteudoTopico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConteudoTopicoRepository extends JpaRepository<ConteudoTopico, Long>, JpaSpecificationExecutor<ConteudoTopico> {
    @Query(value = "select ct.* from public.conteudo_topico ct " +
            "join conteudo_usuario cu on cu.id_conteudo = ct.id_contuedo " +
            "join conteudo c on c.id_conteudo = cu.id_conteudo " +
            "where ct.ativo is true " +
            "and cu.ativo is true " +
            "and cu.id_usuario = :idUsuario " +
            "order by c.nome asc", nativeQuery = true)
    List<ConteudoTopico> buscaPorIdUsuario(@Param(value = "idUsuario") Long idUsuario);
}
