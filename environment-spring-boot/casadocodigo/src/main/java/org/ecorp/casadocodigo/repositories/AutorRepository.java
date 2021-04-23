package org.ecorp.casadocodigo.repositories;

import java.util.List;
import java.util.Optional;
import org.ecorp.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

  Boolean existsAutorEntityByAutorEmail(String value);

  Optional<List<Autor>> findByAutorNome(String autor);

}