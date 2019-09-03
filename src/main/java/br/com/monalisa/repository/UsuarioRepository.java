package br.com.monalisa.repository;

import br.com.monalisa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

    @Query(value = "select * from usuario where id_usuario = :idUsuario", nativeQuery = true)
    Usuario findByIdUsuario(Long idUsuario);

    @Query(value = "select * from usuario where email like :email", nativeQuery = true)
    Usuario findByEmail(@Param("email") String email);

    @Query(value = "select * from usuario where login like :login", nativeQuery = true)
    Usuario findByLogin(String login);
}
