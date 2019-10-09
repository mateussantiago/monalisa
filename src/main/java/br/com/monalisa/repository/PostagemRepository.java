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
    @Query(value = "select * from postagem p " +
            "join assunto_turma ast on ast.id_assunto_turma = p.id_assunto_turma " +
            "join turma t on t.id_turma = ast.id_turma " +
            "join turma_usuario tu on tu.id_turma = t.id_turma " +
            "where p.ativo is true " +
            "and p.id_postagem_genitora is null " +
            "and tu.id_usuario = :idUsuario", nativeQuery = true)
    List<Postagem> buscarPrincipais(@Param("idUsuario") Long idUsuario);

    @Query(value = "select * from postagem p " +
            "join assunto_turma ast on ast.id_assunto_turma = p.id_assunto_turma " +
            "where p.ativo is true " +
            "and id_postagem_genitora is null " +
            "and ast.id_turma = :idTurma", nativeQuery = true)
    List<Postagem> buscarPostagensPorTurma(@Param("idTurma") Long idTurma);

    @Query(value = "select * from postagem where ativo is true", nativeQuery = true)
    List<Postagem> buscarTodos();

    @Query(value = "select * from postagem where id_postagem = :idPostagem", nativeQuery = true)
    Postagem buscarPorId(@Param(value = "idPostagem") Long idPostagem);
}