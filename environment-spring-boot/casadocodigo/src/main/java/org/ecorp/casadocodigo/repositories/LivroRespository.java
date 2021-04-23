package org.ecorp.casadocodigo.repositories;

import org.ecorp.casadocodigo.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRespository extends JpaRepository<Livro, Long> {

}
