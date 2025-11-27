package br.com.dio.desafio.infra.config;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Component
public class FlywayRunner {
    private final DataSource dataSource;

    public FlywayRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void migrate() {
        Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load()
                .migrate();
    }
}

