package org.ecorp.casadocodigo.repositories;

import org.ecorp.casadocodigo.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

}
