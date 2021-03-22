package br.com.armando.decasadocodigo.api.controller;

import br.com.armando.decasadocodigo.api.model.input.AuthorInput;
import br.com.armando.decasadocodigo.domain.model.Author;
import br.com.armando.decasadocodigo.domain.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public Author insert(@RequestBody @Valid AuthorInput authorInput) {
        return authorRepository.save(authorInput.toModel());
    }

}
