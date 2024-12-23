package cryss.dev.author_api.infrastructure.adaptadores.repositories;

import cryss.dev.author_api.infrastructure.adaptadores.entities.AuthorJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringAuthorRepositoryJPA extends JpaRepository<AuthorJPAEntity, Long> {
}
