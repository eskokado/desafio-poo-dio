package br.com.dio.desafio.infra.repository;

import br.com.dio.desafio.infra.entity.BootcampEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<BootcampEntity, Long> { }

