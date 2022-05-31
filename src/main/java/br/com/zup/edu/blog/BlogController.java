package br.com.zup.edu.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping
    public ResponseEntity<Void> cadastraBlog(@RequestBody @Valid BlogRequest blogRequest, UriComponentsBuilder uri){
        Blog blog = blogRequest.toModel();
        blogRepository.save(blog);

        URI location = uri.path("/blog/{id}")
                .buildAndExpand(blog.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PostMapping("{id}/artigos")
    public ResponseEntity<Void> cadastraArtigo(@RequestBody @Valid ArtigoRequest artigoRequest, UriComponentsBuilder uri, @PathVariable Long id){
        Blog blog = blogRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Blog inexistente"));
        Artigo artigo = artigoRequest.toModel(blog);
        blog.adiciona(artigo);
        blogRepository.save(blog);

        URI location = uri.path("/blog/{id}")
                .buildAndExpand(blog.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
