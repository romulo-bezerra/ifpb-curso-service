package br.edu.ifpb.ifpbcurso.web;

import br.edu.ifpb.ifpbcurso.domain.Disciplina;
import br.edu.ifpb.ifpbcurso.service.DisciplinaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbcursoservice/disciplina")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<Disciplina> salvarDisciplina(@RequestBody Disciplina disciplina) {
        return ResponseEntity.ok().body(disciplinaService.salvarDisciplina(disciplina));
    }

    @GetMapping("todas")
    public ResponseEntity<List<Disciplina>> getTodas() {
        return ResponseEntity.ok().body(disciplinaService.listarTodas());
    }

    @GetMapping
    public ResponseEntity<Disciplina> findDisciplinaById(@RequestParam("id") Long id) {
        Optional<Disciplina> disciplina = disciplinaService.buscarPorId(id);
        if (disciplina.isPresent()) return ResponseEntity.ok().body(disciplina.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Disciplina de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<Disciplina> atualizaDisciplina (@RequestBody Disciplina disciplina) {
        return ResponseEntity.ok().body(disciplinaService.salvarDisciplina(disciplina));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDisciplina(@RequestParam("id") Long id) {
        Optional<Disciplina> disciplina = disciplinaService.buscarPorId(id);
        if (disciplina.isPresent()) {
            disciplinaService.apagarDisciplina(disciplina.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Disciplina de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
