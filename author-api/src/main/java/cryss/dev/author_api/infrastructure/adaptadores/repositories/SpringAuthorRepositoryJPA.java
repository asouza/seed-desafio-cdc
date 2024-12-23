package cryss.dev.author_api.infrastructure.adaptadores.repositories;

import cryss.dev.author_api.infrastructure.adaptadores.entities.AuthorJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringAuthorRepositoryJPA extends JpaRepository<AuthorJPAEntity, Long> {
    @Query(value = "SELECT a FROM AuthorJPAEntity a WHERE a.email = ?1")
    Optional<Boolean> findAuthorByEmail(String value);
}
