package br.com.dio.desafio.api;

import br.com.dio.desafio.api.dto.DevCreateRequest;
import br.com.dio.desafio.infra.entity.DevEntity;
import br.com.dio.desafio.service.DevService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devs")
public class DevController {
    private final DevService devService;

    public DevController(DevService devService) {
        this.devService = devService;
    }

    @PostMapping
    public DevEntity criar(@RequestBody DevCreateRequest req) {
        return devService.criarDev(req.getNome());
    }

    @GetMapping
    public List<DevEntity> listar() {
        return devService.listar();
    }

    @PostMapping("/{id}/progredir")
    public void progredir(@PathVariable Long id) {
        devService.progredir(id);
    }

    @GetMapping("/{id}/xp")
    public double xp(@PathVariable Long id) {
        return devService.calcularXp(id);
    }
}

