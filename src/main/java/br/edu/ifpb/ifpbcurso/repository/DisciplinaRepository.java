package br.edu.ifpb.ifpbcurso.repository;

import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

    public Optional<Disciplina> findById(@Param("id") Long id);

    @Query("SELECT d FROM Disciplina d WHERE d.curso.id = :cursoId")
    public Optional<List<Disciplina>> findByCursoId(@Param("cursoId") Long cursoId);

}
