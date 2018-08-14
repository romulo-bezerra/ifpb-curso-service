package br.edu.ifpb.ifpbcurso.web;


import br.edu.ifpb.ifpbcurso.domain.Curso;
import br.edu.ifpb.ifpbcurso.service.CursoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<Curso> salvarCurso(@RequestBody Curso curso) {
        return ResponseEntity.ok().body(cursoService.salvarCurso(curso));
    }

    @GetMapping("todos")
    public ResponseEntity<List<Curso>> getTodos() {
        return ResponseEntity.ok().body(cursoService.listarTodos());
    }


    @GetMapping
    public ResponseEntity<Curso> findCursoById(@RequestParam("id") Long id) {
        Optional<Curso> curso = cursoService.buscarPorId(id);
        if (curso.isPresent()) return ResponseEntity.ok().build();
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Curso de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<Curso> atualizaCurso (@RequestBody Curso curso) {
        return ResponseEntity.ok().body(cursoService.salvarCurso(curso));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCurso(@RequestParam("id") Long id) {
        Optional<Curso> curso = cursoService.buscarPorId(id);
        if (curso.isPresent()) {
            cursoService.apagarCurso(curso.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Curso de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
