package cryss.dev.author_api.domain.adapters.services;

import cryss.dev.author_api.infrastructure.configuration.mapper.AuthorMapper;
import cryss.dev.author_api.domain.ports.repositories.AuthorRepository;
import cryss.dev.author_api.domain.ports.services.CreateNewAuthor;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//import javax.validation.Valid;

@Component
@RequiredArgsConstructor
@Validated
public class CreateNewAuthorSpring implements CreateNewAuthor {

    private final  AuthorMapper mapper;
    private final AuthorRepository repository;

    @Override
    public AuthorResponse create(NewAuthor author) {
        var domain = mapper.toAuthor (author);
        var entity = repository.create (domain);
        return mapper.toAuthorResponse (entity);
    }
}
