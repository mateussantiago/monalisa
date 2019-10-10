package br.com.monalisa.repository;

import br.com.monalisa.model.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DenunciaRepository extends JpaRepository<Denuncia, Long>, JpaSpecificationExecutor<Denuncia> {
    @Query(value = "select * from denuncia where ativo is true", nativeQuery = true)
    List<Denuncia> buscarTodos();

    @Query(value = "select * from denuncia where id_denuncia = :id and ativo is true", nativeQuery = true)
    Denuncia buscarPorId(@Param(value = "id") Long id);

    @Query(value = "select count(d.*) from denuncia as d"+
                    "join postagem as p on p.id_postagem = d.id_postagem" +
                    "join usuario as u on u.id_usuario = p.id_usuario" +
                    "where u.id_usuario = :idusuario", nativeQuery = true)
    Long contarDenuncias(@Param(value = "idusuario") Long id);
}
