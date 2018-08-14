package br.edu.ifpb.ifpbcurso.repository;

import br.edu.ifpb.ifpbcurso.domain.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    public Optional<Unidade> findById(@Param("id") Long id);

}
