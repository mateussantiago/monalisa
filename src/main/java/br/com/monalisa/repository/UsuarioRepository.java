package br.com.monalisa.repository;

import br.com.monalisa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {
    @Query(value = "select * from public.usuario where ativo is true", nativeQuery = true)
    List<Usuario> buscarTodos();

    @Query(value = "select * from usuario where id_usuario = :id", nativeQuery = true)
    Usuario buscarPorId(@Param(value = "id") Long idUsuario);

    @Query(value = "select * from usuario where email like :email", nativeQuery = true)
    Usuario buscarPorEmail(@Param("email") String email);

    @Query(value = "select * from usuario where login like :login", nativeQuery = true)
    Usuario buscarPorLogin(@Param("login") String login);
}
