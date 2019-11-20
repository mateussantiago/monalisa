package br.com.monalisa.framework.repository;

import br.com.monalisa.framework.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    @Query(value = "select * from usuario where ativo is true and email like :email", nativeQuery = true)
    Usuario buscarPorEmail(@Param("email") String email);

    @Query(value = "select * from usuario where ativo is true and login like :login", nativeQuery = true)
    Usuario buscarPorLogin(@Param("login") String login);
}
