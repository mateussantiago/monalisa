package br.com.framework.repository;

import br.com.framework.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaSpecificationExecutor<Topico>, JpaRepository<Topico, Long> {
}
