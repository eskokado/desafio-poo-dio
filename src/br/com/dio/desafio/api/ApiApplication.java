package br.com.dio.desafio.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "br.com.dio.desafio")
@EnableJpaRepositories(basePackages = "br.com.dio.desafio.infra.repository")
@EntityScan(basePackages = "br.com.dio.desafio.infra.entity")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}

