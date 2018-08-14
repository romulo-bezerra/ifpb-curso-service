package br.edu.ifpb.ifpbcurso.repository;

import br.edu.ifpb.ifpbcurso.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    public Optional<Curso> findById(@Param("id") Long id);

}
