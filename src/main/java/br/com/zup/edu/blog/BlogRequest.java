package br.com.zup.edu.blog;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

public class BlogRequest {

    @NotBlank
    private String nome;

    public BlogRequest(String nome) {
        this.nome = nome;
    }

    public BlogRequest() {
    }

    public String getNome() {
        return nome;
    }

    public Blog toModel(){
        return new Blog(nome);
    }
}
