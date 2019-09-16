package br.com.monalisa.repository;

import br.com.monalisa.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TagRepository extends JpaRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {
    @Query(value = "select * from tag where ativo is true", nativeQuery = true)
    List<Tag> buscarTodos();

    @Query(value = "select * from tag where id_tag = :id and ativo is true", nativeQuery = true)
    Tag buscarPorId(@Param(value = "id") Long id);
}