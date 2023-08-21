package author.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import author.payload.AuthorRequest;
import author.service.AuthorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/author")
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(final AuthorService authorService) {
		this.authorService = authorService;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<String> createAutor(@Valid @RequestBody final AuthorRequest author) {
		authorService.create(author);
		return new ResponseEntity<>("Author is create", HttpStatus.CREATED);
	}

}
