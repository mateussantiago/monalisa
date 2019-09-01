package br.com.monalisa.repository;

import br.com.monalisa.model.Assunto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AssuntoRepository  extends JpaRepository<Assunto, Long>, JpaSpecificationExecutor<Assunto> {
}
