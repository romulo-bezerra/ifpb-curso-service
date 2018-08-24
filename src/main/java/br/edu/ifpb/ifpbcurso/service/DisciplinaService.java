package br.edu.ifpb.ifpbcurso.service;

import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import br.edu.ifpb.ifpbcurso.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina salvarDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina atualizarDisciplina(Disciplina disciplinaAtualizada) {
        return disciplinaRepository.save(disciplinaAtualizada);
    }

    public void apagarDisciplina(Disciplina disciplina) {
        disciplinaRepository.delete(disciplina);
    }

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Optional<List<Disciplina>> findByCursoId(Long cursoId) {
        return disciplinaRepository.findByCursoId(cursoId);
    }

    public Optional<Disciplina> buscarPorId(Long id) {
        return disciplinaRepository.findById(id);
    }
}
