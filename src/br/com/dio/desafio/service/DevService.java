package br.com.dio.desafio.service;

import br.com.dio.desafio.infra.entity.ConteudoEntity;
import br.com.dio.desafio.infra.entity.DevEntity;
import br.com.dio.desafio.infra.entity.CursoEntity;
import br.com.dio.desafio.infra.entity.MentoriaEntity;
import br.com.dio.desafio.infra.repository.DevRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DevService {
    private final DevRepository devRepository;

    public DevService(DevRepository devRepository) {
        this.devRepository = devRepository;
    }

    public DevEntity criarDev(String nome) {
        DevEntity d = new DevEntity();
        d.setNome(nome);
        return devRepository.save(d);
    }

    public List<DevEntity> listar() {
        return devRepository.findAll();
    }

    public void progredir(Long devId) {
        DevEntity d = devRepository.findById(devId).orElseThrow();
        Optional<ConteudoEntity> conteudo = d.getConteudosInscritos().stream().findFirst();
        conteudo.ifPresent(c -> {
            d.getConteudosConcluidos().add(c);
            d.getConteudosInscritos().remove(c);
            devRepository.save(d);
        });
    }

    public double calcularXp(Long devId) {
        DevEntity d = devRepository.findById(devId).orElseThrow();
        Iterator<ConteudoEntity> it = d.getConteudosConcluidos().iterator();
        double soma = 0d;
        while (it.hasNext()) {
            ConteudoEntity c = it.next();
            if (c instanceof CursoEntity) {
                soma += ((CursoEntity) c).calcularXp();
            } else if (c instanceof MentoriaEntity) {
                soma += ((MentoriaEntity) c).calcularXp();
            }
        }
        return soma;
    }
}

