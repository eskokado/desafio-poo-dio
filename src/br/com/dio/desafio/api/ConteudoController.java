package br.com.dio.desafio.api;

import br.com.dio.desafio.infra.entity.ConteudoEntity;
import br.com.dio.desafio.infra.repository.ConteudoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/conteudos")
public class ConteudoController {
    private final ConteudoRepository conteudoRepository;

    public ConteudoController(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    @GetMapping
    public List<ConteudoEntity> listar() {
        return conteudoRepository.findAll();
    }
}

