package br.com.dio.desafio.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class MentoriaCreateRequest {
    private String titulo;
    private String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
}

