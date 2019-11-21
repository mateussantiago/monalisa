package br.com.monalisa.framework.repository;

import br.com.monalisa.framework.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>, JpaSpecificationExecutor<Postagem> {

    @Query(value = "select * from postagem where id_postagem = :idPostagem", nativeQuery = true)
    Postagem buscarPorId(@Param(value = "idPostagem") Long idPostagem);

    @Query(value = "select * from postagem p " +
            "join public.conteudo_topico ct on ct.id_conteudo_topico = p.id_conteudo_topico " +
            "join public.conteudo c on c.id_conteudo = ct.id_conteudo " +
            "join public.conteudo_usuario cu on cu.id_conteudo = c.id_conteudo " +
            "where p.ativo is true " +
            "and p.id_postagem_genitora is null " +
            "and tu.id_usuario = :idUsuario", nativeQuery = true)
    List<Postagem> buscarPrincipais(@Param("idUsuario") Long idUsuario);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE postagem SET ativo = false WHERE id_postagem = :idPostagem", nativeQuery = true)
    void remover(@Param(value = "idPostagem") Long idPostagem);
}
