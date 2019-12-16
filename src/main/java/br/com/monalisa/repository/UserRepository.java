package br.com.monalisa.repository;

import br.com.monalisa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    @Query(value = "select * from usuario where ativo is true", nativeQuery = true)
    List<User> findAll();

    @Query(value = "select * from usuario where ativo is true and id_usuario = :id", nativeQuery = true)
    Optional<User> findById(@Param(value = "id") Long idUsuario);

    @Query(value = "select * from usuario where ativo is true and email like :email", nativeQuery = true)
    Optional<User> findByEmail(@Param("email") String email);

    @Query(value = "select * from usuario where ativo is true and login like :login", nativeQuery = true)
    Optional<User> findByLogin(@Param("login") String login);
}
