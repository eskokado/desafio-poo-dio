package br.com.dio.desafio.service;

import br.com.dio.desafio.infra.entity.*;
import br.com.dio.desafio.infra.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BootcampService {
    private final BootcampRepository bootcampRepository;
    private final CursoRepository cursoRepository;
    private final MentoriaRepository mentoriaRepository;
    private final DevRepository devRepository;

    public BootcampService(BootcampRepository bootcampRepository,
                           CursoRepository cursoRepository,
                           MentoriaRepository mentoriaRepository,
                           DevRepository devRepository) {
        this.bootcampRepository = bootcampRepository;
        this.cursoRepository = cursoRepository;
        this.mentoriaRepository = mentoriaRepository;
        this.devRepository = devRepository;
    }

    public BootcampEntity criarBootcamp(String nome, String descricao) {
        BootcampEntity b = new BootcampEntity();
        b.setNome(nome);
        b.setDescricao(descricao);
        b.setDataInicial(LocalDate.now());
        b.setDataFinal(b.getDataInicial().plusDays(45));
        return bootcampRepository.save(b);
    }

    public List<BootcampEntity> listar() {
        return bootcampRepository.findAll();
    }

    public BootcampEntity adicionarCurso(Long bootcampId, String titulo, String descricao, int cargaHoraria) {
        BootcampEntity b = bootcampRepository.findById(bootcampId).orElseThrow();
        CursoEntity c = new CursoEntity();
        c.setTitulo(titulo);
        c.setDescricao(descricao);
        c.setCargaHoraria(cargaHoraria);
        c = cursoRepository.save(c);
        b.getConteudos().add(c);
        return bootcampRepository.save(b);
    }

    public BootcampEntity adicionarMentoria(Long bootcampId, String titulo, String descricao, LocalDate data) {
        BootcampEntity b = bootcampRepository.findById(bootcampId).orElseThrow();
        MentoriaEntity m = new MentoriaEntity();
        m.setTitulo(titulo);
        m.setDescricao(descricao);
        m.setData(data);
        m = mentoriaRepository.save(m);
        b.getConteudos().add(m);
        return bootcampRepository.save(b);
    }

    public void inscreverDev(Long bootcampId, Long devId) {
        BootcampEntity b = bootcampRepository.findById(bootcampId).orElseThrow();
        DevEntity d = devRepository.findById(devId).orElseThrow();
        d.getConteudosInscritos().addAll(b.getConteudos());
        devRepository.save(d);
    }
}

