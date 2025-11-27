package br.com.dio.desafio.api;

import br.com.dio.desafio.api.dto.BootcampCreateRequest;
import br.com.dio.desafio.api.dto.CursoCreateRequest;
import br.com.dio.desafio.api.dto.MentoriaCreateRequest;
import br.com.dio.desafio.infra.entity.BootcampEntity;
import br.com.dio.desafio.service.BootcampService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bootcamps")
public class BootcampController {
    private final BootcampService bootcampService;

    public BootcampController(BootcampService bootcampService) {
        this.bootcampService = bootcampService;
    }

    @PostMapping
    public BootcampEntity criar(@RequestBody BootcampCreateRequest req) {
        return bootcampService.criarBootcamp(req.getNome(), req.getDescricao());
    }

    @GetMapping
    public List<BootcampEntity> listar() {
        return bootcampService.listar();
    }

    @PostMapping("/{id}/cursos")
    public BootcampEntity adicionarCurso(@PathVariable Long id,
                                         @RequestBody CursoCreateRequest req) {
        return bootcampService.adicionarCurso(id, req.getTitulo(), req.getDescricao(), req.getCargaHoraria());
    }

    @PostMapping("/{id}/mentorias")
    public BootcampEntity adicionarMentoria(@PathVariable Long id,
                                            @RequestBody MentoriaCreateRequest req) {
        return bootcampService.adicionarMentoria(id, req.getTitulo(), req.getDescricao(), req.getData());
    }

    @PostMapping("/{id}/inscricoes/{devId}")
    public void inscreverDev(@PathVariable Long id, @PathVariable Long devId) {
        bootcampService.inscreverDev(id, devId);
    }
}

