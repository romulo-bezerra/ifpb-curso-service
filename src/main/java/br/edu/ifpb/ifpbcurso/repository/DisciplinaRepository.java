package br.edu.ifpb.ifpbcurso.repository;

import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    public Optional<Disciplina> findById(@Param("id") Long id);

}
