package br.com.armando.decasadocodigo.domain.repository;

import br.com.armando.decasadocodigo.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
