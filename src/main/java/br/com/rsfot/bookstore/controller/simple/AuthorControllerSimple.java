package br.com.rsfot.bookstore.controller.simple;

import br.com.rsfot.bookstore.author.Author;
import br.com.rsfot.bookstore.author.NewAuthorRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorControllerSimple {
    @PersistenceContext
    private final EntityManager entityManager;

    public AuthorControllerSimple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @PostMapping(path = "/author-simple", consumes = "application/json")
    ResponseEntity<String> create(@RequestBody @Valid NewAuthorRequest newAuthorRequest) {
        Author newAuthor = newAuthorRequest.toModel();
        entityManager.persist(newAuthor);
        return ResponseEntity.ok().body(newAuthor.toString());
    }

}
