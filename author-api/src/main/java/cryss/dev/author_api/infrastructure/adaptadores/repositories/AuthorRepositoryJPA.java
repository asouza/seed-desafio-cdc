package cryss.dev.author_api.infrastructure.adaptadores.repositories;

import cryss.dev.author_api.domain.Author;
import cryss.dev.author_api.domain.ports.repositories.AuthorRepository;
import cryss.dev.author_api.infrastructure.configuration.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class AuthorRepositoryJPA implements AuthorRepository {

    private final SpringAuthorRepositoryJPA repository;
    private final AuthorMapper mapper;


    @Override
    public Author create(Author author) {
        var entity = mapper.toAuthorJPAEntity(author);
        var result = repository.save (entity);
        var domain = mapper.toAuthor (result);
        log.info ("message={}, method={}, request={}","Creating a new Author", "create",  result .getId ());
        return domain ;
    }
}
