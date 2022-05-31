package br.com.zup.edu.blog;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ArtigoRequest {

    @NotBlank @Size(max = 200)
    private String titulo;

    @NotBlank @Size(max = 10000)
    private String corpo;

    @NotNull
    private Tipo tipo;

    public ArtigoRequest(String titulo, String corpo, Tipo tipo) {
        this.titulo = titulo;
        this.corpo = corpo;
        this.tipo = tipo;
    }

    public ArtigoRequest() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Artigo toModel(Blog blog){
        return new Artigo(titulo, corpo, tipo, blog);
    }
}
