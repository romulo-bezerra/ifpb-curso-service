package br.edu.ifpb.ifpbcurso.web;

import br.edu.ifpb.ifpbcurso.domain.Unidade;
import br.edu.ifpb.ifpbcurso.service.UnidadeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ifpbcursoservice/unidade")
public class UnidadeController {

    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @PostMapping
    public ResponseEntity<Unidade> salvarUnidade(@RequestBody Unidade unidade) {
        return ResponseEntity.ok().body(unidadeService.salvarUnidade(unidade));
    }

    @GetMapping("todas")
    public ResponseEntity<List<Unidade>> getTodas() {
        return ResponseEntity.ok().body(unidadeService.listarTodas());
    }

    @GetMapping
    public ResponseEntity<Unidade> findUnidadeById(@RequestParam("id") Long id) {
        Optional<Unidade> unidade = unidadeService.buscarPorId(id);
        if (unidade.isPresent()) return ResponseEntity.ok().body(unidade.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Unidade de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    public ResponseEntity<Unidade> atualizaUnidade (@RequestBody Unidade unidade) {
        return ResponseEntity.ok().body(unidadeService.salvarUnidade(unidade));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUnidade(@RequestParam("id") Long id) {
        Optional<Unidade> unidade = unidadeService.buscarPorId(id);
        if (unidade.isPresent()) {
            unidadeService.apagarUnidade(unidade.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Unidade de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
