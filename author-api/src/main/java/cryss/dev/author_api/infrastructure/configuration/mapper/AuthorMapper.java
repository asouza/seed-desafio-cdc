package cryss.dev.author_api.infrastructure.configuration.mapper;

import cryss.dev.author_api.domain.Author;
import cryss.dev.author_api.infrastructure.adaptadores.entities.AuthorJPAEntity;
import org.mapstruct.Mapper;
import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthor(NewAuthor author);

    Author toAuthor(AuthorJPAEntity author);

    AuthorResponse toAuthorResponse(Author entity);

    AuthorJPAEntity toAuthorJPAEntity(Author author);
}
