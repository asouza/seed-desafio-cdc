package cryss.dev.author_api.application.adapters.controller;

import cryss.dev.author_api.domain.ports.services.CreateNewAuthor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.openapitools.api.AuthorApi;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Log4j2
public class AuthorController implements AuthorApi {

    private final CreateNewAuthor createNewAuthor;

    @Override
    public ResponseEntity<AuthorResponse> create(NewAuthor newAuthor) {
        log.info ("message={}, method={}, request={}","Creating a new Author", "create", newAuthor );
        return ResponseEntity.ok (createNewAuthor.create (newAuthor ));
    }
}
