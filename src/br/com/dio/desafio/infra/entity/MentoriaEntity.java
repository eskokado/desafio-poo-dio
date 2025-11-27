package br.com.dio.desafio.infra.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "mentorias")
@DiscriminatorValue("MENTORIA")
public class MentoriaEntity extends ConteudoEntity {
    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Override
    public double calcularXp() {
        return 10d + 20d;
    }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}

