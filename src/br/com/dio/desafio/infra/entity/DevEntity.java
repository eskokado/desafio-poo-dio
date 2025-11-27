package br.com.dio.desafio.infra.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "devs")
public class DevEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(name = "devs_inscritos",
            joinColumns = @JoinColumn(name = "dev_id"),
            inverseJoinColumns = @JoinColumn(name = "conteudo_id"))
    private Set<ConteudoEntity> conteudosInscritos = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "devs_concluidos",
            joinColumns = @JoinColumn(name = "dev_id"),
            inverseJoinColumns = @JoinColumn(name = "conteudo_id"))
    private Set<ConteudoEntity> conteudosConcluidos = new LinkedHashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Set<ConteudoEntity> getConteudosInscritos() { return conteudosInscritos; }
    public void setConteudosInscritos(Set<ConteudoEntity> conteudosInscritos) { this.conteudosInscritos = conteudosInscritos; }
    public Set<ConteudoEntity> getConteudosConcluidos() { return conteudosConcluidos; }
    public void setConteudosConcluidos(Set<ConteudoEntity> conteudosConcluidos) { this.conteudosConcluidos = conteudosConcluidos; }
}

