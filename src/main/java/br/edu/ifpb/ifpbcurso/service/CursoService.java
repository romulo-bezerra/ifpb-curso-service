package br.edu.ifpb.ifpbcurso.service;

import br.edu.ifpb.ifpbcurso.domain.Curso;
import br.edu.ifpb.ifpbcurso.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso atualizarCurso(Curso cursoAtualizado) {
        return cursoRepository.save(cursoAtualizado);
    }

    public void apagarCurso(Curso curso) {
        cursoRepository.delete(curso);
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(Integer id) {
        return cursoRepository.findById(id);
    }
}
