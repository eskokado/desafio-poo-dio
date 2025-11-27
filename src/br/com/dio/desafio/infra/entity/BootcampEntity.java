package br.com.dio.desafio.infra.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bootcamps")
public class BootcampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "data_inicial", nullable = false)
    private LocalDate dataInicial = LocalDate.now();

    @Column(name = "data_final", nullable = false)
    private LocalDate dataFinal = dataInicial.plusDays(45);

    @ManyToMany
    @JoinTable(name = "bootcamp_conteudos",
            joinColumns = @JoinColumn(name = "bootcamp_id"),
            inverseJoinColumns = @JoinColumn(name = "conteudo_id"))
    private Set<ConteudoEntity> conteudos = new LinkedHashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public LocalDate getDataInicial() { return dataInicial; }
    public void setDataInicial(LocalDate dataInicial) { this.dataInicial = dataInicial; }
    public LocalDate getDataFinal() { return dataFinal; }
    public void setDataFinal(LocalDate dataFinal) { this.dataFinal = dataFinal; }
    public Set<ConteudoEntity> getConteudos() { return conteudos; }
    public void setConteudos(Set<ConteudoEntity> conteudos) { this.conteudos = conteudos; }
}

