package br.com.zup.edu.blog;

import javax.persistence.*;

@Entity
public class Artigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false, length = 10000)
    private String corpo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @ManyToOne
    private Blog blog;

    public Artigo(String titulo, String corpo, Tipo tipo, Blog blog) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.tipo = tipo;
        this.blog = blog;
    }

    @Deprecated
    public Artigo() {
    }

    public Long getId() {
        return id;
    }
}
