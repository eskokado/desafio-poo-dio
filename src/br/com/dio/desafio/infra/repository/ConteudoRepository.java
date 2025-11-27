package br.com.dio.desafio.infra.repository;

import br.com.dio.desafio.infra.entity.ConteudoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConteudoRepository extends JpaRepository<ConteudoEntity, Long> { }

