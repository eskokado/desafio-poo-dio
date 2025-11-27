package br.com.dio.desafio.infra.repository;

import br.com.dio.desafio.infra.entity.DevEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevRepository extends JpaRepository<DevEntity, Long> { }

