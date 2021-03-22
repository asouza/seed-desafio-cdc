package br.com.armando.decasadocodigo.domain.repository;

import br.com.armando.decasadocodigo.domain.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
