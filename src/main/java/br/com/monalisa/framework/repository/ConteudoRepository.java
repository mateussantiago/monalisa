package br.com.monalisa.framework.repository;

import br.com.monalisa.framework.model.Conteudo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long>, JpaSpecificationExecutor<Conteudo> {

}
