package br.com.monalisa.repository;

import br.com.framework.model.Conteudo;
import br.com.framework.repository.ConteudoRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends ConteudoRepository {

    @Query(value = "select c.* from conteudo c " +
            "where c.id_conteudo not in ( " +
            "select c.id_conteudo from conteudo c " +
            "join conteudo_usuario cu on cu.id_conteudo = c.id_conteudo " +
            "where cu.id_usuario = :idUsuario) " +
            "and lower(c.nome) like concat('%', lower(cast(:nome as text)), '%');",
            nativeQuery = true)
    List<Conteudo> buscarTurmasPorNome(@Param("nome") String nome);

    @Query(value = "select c.* from conteudo c " +
            "join conteudo_topico ct on ct.id_conteudo = c.id_conteudo " +
            "join topico t on t.id_topico = ct.id_topico " +
            "where c.id_conteudo not in ( " +
            "	select c.id_conteudo from conteudo c " +
            "	join conteudo_usuario cu on cu.id_conteudo = c.id_conteudo " +
            "	where cu.id_usuario = :idUsuario) " +
            "and lower(t.nome) like concat('%', lower(cast(:topico as text)), '%');", nativeQuery = true)
    List<Conteudo> buscarTurmaPorAssunto(@Param("topico") String topico);
}
