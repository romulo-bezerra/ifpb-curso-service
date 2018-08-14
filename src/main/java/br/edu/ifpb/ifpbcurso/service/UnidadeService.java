package br.edu.ifpb.ifpbcurso.service;

import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import br.edu.ifpb.ifpbcurso.domain.Unidade;
import br.edu.ifpb.ifpbcurso.repository.DisciplinaRepository;
import br.edu.ifpb.ifpbcurso.repository.UnidadeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {

    private final UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public Unidade salvarUnidade(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    public Unidade atualizarUnidade(Unidade unidadeAtualizada) {
        return unidadeRepository.save(unidadeAtualizada);
    }

    public void apagarUnidade(Unidade unidade) {
        unidadeRepository.delete(unidade);
    }

    public List<Unidade> listarTodas() {
        return unidadeRepository.findAll();
    }

    public Optional<Unidade> buscarPorId(Integer id) {
        return unidadeRepository.findById(id);
    }
}
