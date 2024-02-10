package br.com.rsfot.bookstore.author;

import br.com.rsfot.bookstore.error.handler.EmailDuplicatedException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    @PostMapping(path = "/authors", consumes = "application/json")
    ResponseEntity<NewAuthorResponse> create(@Valid @RequestBody NewAuthorRequest newAuthorRequest) {
        if (authorRepository.existsByEmail(newAuthorRequest.email())) {
            throw new EmailDuplicatedException(newAuthorRequest.email());
        }

        Author author = newAuthorRequest.toModel();
        authorRepository.save(author);
        return ResponseEntity.ok().body(new NewAuthorResponse(author));
    }
}
