package br.com.monalisa.repository;

import br.com.monalisa.model.AssuntoTurmaPostagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuntoTurmaPostagemRepository  extends JpaRepository<AssuntoTurmaPostagem, Long>, JpaSpecificationExecutor<AssuntoTurmaPostagem> {
}
