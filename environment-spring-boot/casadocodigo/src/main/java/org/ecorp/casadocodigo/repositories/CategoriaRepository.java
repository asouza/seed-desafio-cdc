package org.ecorp.casadocodigo.repositories;

import org.ecorp.casadocodigo.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
