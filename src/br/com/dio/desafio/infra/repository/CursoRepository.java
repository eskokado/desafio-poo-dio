package br.com.dio.desafio.infra.repository;

import br.com.dio.desafio.infra.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity, Long> { }

