package br.com.dio.desafio.infra.repository;

import br.com.dio.desafio.infra.entity.MentoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentoriaRepository extends JpaRepository<MentoriaEntity, Long> { }

