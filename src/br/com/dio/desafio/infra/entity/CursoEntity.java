package br.com.dio.desafio.infra.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cursos")
@DiscriminatorValue("CURSO")
public class CursoEntity extends ConteudoEntity {
    @Column(name = "carga_horaria", nullable = false)
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return 10d * cargaHoraria;
    }

    public int getCargaHoraria() { return cargaHoraria; }
    public void setCargaHoraria(int cargaHoraria) { this.cargaHoraria = cargaHoraria; }
}

