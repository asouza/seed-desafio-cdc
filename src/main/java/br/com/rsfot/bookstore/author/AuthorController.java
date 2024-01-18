package br.com.rsfot.bookstore.author;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    @PostMapping(path = "/authors", consumes = "application/json")
    ResponseEntity<String> create(@Valid @RequestBody NewAuthorRequest newAuthorRequest) {
//        if (bindingResult.hasErrors())
//            return ResponseEntity.badRequest().build();
//        if (authorRepository.existsByEmail(newAuthorRequest.email()))
//            return ResponseEntity.badRequest().body("Email already exists");



        Author author = newAuthorRequest.toModel();
        authorRepository.save(author);
        return ResponseEntity.ok().body(new NewAuthorResponse(author).toString());
    }
}
