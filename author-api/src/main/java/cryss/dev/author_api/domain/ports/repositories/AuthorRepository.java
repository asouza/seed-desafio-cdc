package cryss.dev.author_api.domain.ports.repositories;

import cryss.dev.author_api.domain.Author;

public interface AuthorRepository {
    Author create(Author author);
}
