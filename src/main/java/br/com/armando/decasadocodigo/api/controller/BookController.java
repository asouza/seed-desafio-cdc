package br.com.armando.decasadocodigo.api.controller;

import br.com.armando.decasadocodigo.api.model.request.BookRequest;
import br.com.armando.decasadocodigo.api.model.response.BookResponse;
import br.com.armando.decasadocodigo.api.model.response.BookSummaryResponse;
import br.com.armando.decasadocodigo.domain.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookSummaryResponse> list() {
        return manager.createQuery("SELECT book FROM Book book join fetch book.author join fetch book.category", Book.class)
                .getResultList().stream().map(book -> new BookSummaryResponse(book))
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{bookId}")
    public ResponseEntity<BookResponse> findById(@PathVariable Long bookId) {
        Book book = manager.find(Book.class, bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(new BookResponse(book));
        }
    }

}
