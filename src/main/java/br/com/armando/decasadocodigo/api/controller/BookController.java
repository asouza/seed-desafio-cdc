package br.com.armando.decasadocodigo.api.controller;

import br.com.armando.decasadocodigo.api.model.request.BookRequest;
import br.com.armando.decasadocodigo.api.model.response.BookResponse;
import br.com.armando.decasadocodigo.domain.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public BookResponse insert(@RequestBody @Valid BookRequest bookRequest) {
        Book book = bookRequest.toModel(manager);
        manager.persist(book);
        return new BookResponse(book);
    }

}
