package br.com.monalisa.repository;

import br.com.monalisa.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>, JpaSpecificationExecutor<Postagem> {
    @Query(value = "select * from postagem where ativo is true", nativeQuery = true)
    List<Postagem> findAll();

    @Query(value = "select * from postagem where id_postagem = :idPostagem", nativeQuery = true)
    Postagem findPostagemById(@Param(value = "idPostagem") Long idPostagem);
}