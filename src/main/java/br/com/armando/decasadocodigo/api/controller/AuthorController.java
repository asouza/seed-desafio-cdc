package br.com.armando.decasadocodigo.api.controller;

import br.com.armando.decasadocodigo.api.model.request.AuthorRequest;
import br.com.armando.decasadocodigo.domain.model.Author;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public String insert(@RequestBody @Valid AuthorRequest authorRequest) {
        Author author = authorRequest.toModel();
        manager.persist(author);
        return author.toString();
    }

}
