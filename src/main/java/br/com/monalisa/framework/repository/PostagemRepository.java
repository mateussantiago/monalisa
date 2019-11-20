package br.com.monalisa.framework.repository;

import br.com.monalisa.framework.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>, JpaSpecificationExecutor<Postagem> {

    @Query(value = "select * from postagem where id_postagem = :idPostagem", nativeQuery = true)
    Postagem buscarPorId(@Param(value = "idPostagem") Long idPostagem);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE postagem SET ativo = false WHERE id_postagem = :idPostagem", nativeQuery = true)
    void remover(@Param(value = "idPostagem") Long idPostagem);
}
