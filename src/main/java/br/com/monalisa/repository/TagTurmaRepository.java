package br.com.monalisa.repository;

import br.com.monalisa.model.TagTurma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TagTurmaRepository extends JpaRepository<TagTurma, Long>, JpaSpecificationExecutor<TagTurma> {
}
