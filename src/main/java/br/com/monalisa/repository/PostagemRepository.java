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
    @Query(value = "select p.* " +
            "from postagem p, assunto_turma ast, turma t, turma_usuario tu, usuario u " +
            "where p.ativo is true " +
            "and id_postagem_genitora is null " +
            "and p.id_assunto_turma = ast.id_assunto_turma " +
            "and ast.id_turma = t.id_turma " +
            "and t.id_turma = tu.id_turma " +
            "and tu.id_usuario = :idUsuario", nativeQuery = true)
    List<Postagem> buscarPrincipais(@Param("idUsuario") Long idUsuario);

    @Query(value = "select p.* " +
            "from postagem p, assunto_turma ast " +
            "where p.ativo is true " +
            "and id_postagem_genitora is null " +
            "and ast.id_turma = :idTurma", nativeQuery = true)
    List<Postagem> buscarPostagensPorTurma(@Param("idTurma") Long idTurma);

    @Query(value = "select * from postagem where ativo is true", nativeQuery = true)
    List<Postagem> buscarTodos();

    @Query(value = "select * from postagem where id_postagem = :idPostagem", nativeQuery = true)
    Postagem buscarPorId(@Param(value = "idPostagem") Long idPostagem);
}