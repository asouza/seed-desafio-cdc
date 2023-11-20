package cv.hexadus.seeddesafiocdc.author;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/author")
public class RegisterAuthorController {

    private final AuthorRepository repository;
    @PersistenceContext
    private EntityManager manager;

    public RegisterAuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Object> registerAuthor(@RequestBody @Valid RegisterAuthorRequest request){
        Author author = request.toModel();
        manager.persist(author);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
