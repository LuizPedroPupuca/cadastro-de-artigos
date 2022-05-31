package br.com.zup.edu.blog;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Blog {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "blog", cascade = {CascadeType.ALL})
    private List<Artigo> artigos = new ArrayList<>();

    public Blog(String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void adiciona(Artigo artigo) {
        this.artigos.add(artigo);
    }
}
