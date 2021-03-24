package br.com.armando.decasadocodigo.api.controller;

import br.com.armando.decasadocodigo.api.model.request.AuthorRequest;
import br.com.armando.decasadocodigo.api.validator.DuplicateEmailAuthorValidator;
import br.com.armando.decasadocodigo.domain.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private DuplicateEmailAuthorValidator duplicateEmailAuthorValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(duplicateEmailAuthorValidator);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public String insert(@RequestBody @Valid AuthorRequest authorRequest) {
        Author author = authorRequest.toModel();
        manager.persist(author);
        return author.toString();
    }

}
