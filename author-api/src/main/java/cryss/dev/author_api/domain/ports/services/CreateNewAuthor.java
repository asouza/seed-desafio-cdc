package cryss.dev.author_api.domain.ports.services;

import org.openapitools.model.AuthorResponse;
import org.openapitools.model.NewAuthor;

public interface CreateNewAuthor {
    AuthorResponse create(NewAuthor author);
}
