package br.edu.ifpb.ifpbcurso.repository;

import br.edu.ifpb.ifpbcurso.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
