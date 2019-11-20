package br.com.monalisa.framework.repository;

import br.com.monalisa.framework.model.ConteudoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConteudoUsuarioRepository extends JpaRepository<ConteudoUsuario, Long>, JpaSpecificationExecutor<ConteudoUsuario> {

    @Query(value = "select distinct conu.* from public.conteudo_usuario conu " +
            "where conu.id_usuario = :idUsuario " +
            "and conu.ativo is true", nativeQuery = true)
    List<ConteudoUsuario> buscarPorIdUsuario(@Param(value = "idUsuario") Long idUsuario);

}
