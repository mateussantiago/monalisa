package br.com.monalisa.repository;

import br.com.monalisa.model.TurmaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaUsuarioRepository extends JpaRepository<TurmaUsuario, Long>, JpaSpecificationExecutor<TurmaUsuario> {
}
