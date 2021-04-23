package org.ecorp.casadocodigo.repositories;

import org.ecorp.casadocodigo.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, String> {

  Cupom findByCodigo(String cupom);

}
