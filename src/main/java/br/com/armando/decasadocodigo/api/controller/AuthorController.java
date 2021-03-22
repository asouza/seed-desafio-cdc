package br.com.armando.decasadocodigo.api.controller;

import br.com.armando.decasadocodigo.api.model.input.AuthorInput;
import br.com.armando.decasadocodigo.domain.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public String insert(@RequestBody @Valid AuthorInput authorInput) {
        Author author = authorInput.toModel();
        manager.persist(author);
        return author.toString();
    }

}
