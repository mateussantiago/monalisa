package br.com.framework.repository;

import br.com.framework.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>, JpaSpecificationExecutor<Postagem> {

    @Query(value = "select * from postagem where id_postagem = :idPostagem", nativeQuery = true)
    Postagem buscarPorId(@Param(value = "idPostagem") Long idPostagem);

    @Query(value = "select p.* from postagem p " +
            "join public.topico t on t.id_topico = p.id_topico " +
            "join public.conteudo c on c.id_conteudo = t.id_conteudo " +
            "join public.conteudo_usuario cu on cu.id_conteudo = c.id_conteudo " +
            "where p.ativo is true " +
            "and p.id_postagem_genitora is null " +
            "and cu.id_usuario = :idUsuario", nativeQuery = true)
    List<Postagem> buscarPrincipais(@Param("idUsuario") Long idUsuario);


    @Query(value = "select p.* from postagem p " +
            "join topico t on t.id_topico = p.id_topico " +
            "join conteudo c on c.id_conteudo = t.id_conteudo " +
            "where p.ativo is true " +
            "and t.id_topico = :idTopico " +
            "and c.id_conteudo = :idConteudo", nativeQuery = true)
    List<Postagem> buscarPostagensPorConteudoETopico(@Param("idConteudo") Long idConteudo, @Param("idTopico") Long idTopico);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE postagem SET ativo = false WHERE id_postagem = :idPostagem", nativeQuery = true)
    void remover(@Param(value = "idPostagem") Long idPostagem);
}
