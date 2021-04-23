package org.ecorp.casadocodigo.services;

import java.util.Optional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.PaisDTO;
import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.forms.PaisFormRequest;
import org.ecorp.casadocodigo.model.Pais;
import org.ecorp.casadocodigo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisService {

  @Autowired
  private PaisRepository repository;

  public PaisDTO criar(@Valid PaisFormRequest paisRequest) {
    Pais pais = repository.save(paisRequest.toModel());
    return new PaisDTO(pais);
  }

  public PaisDTO buscaPorId(Long id) {
    Optional<Pais> found = repository.findById(id);
    if (found.isEmpty())
      throw new ResourceNotFoundException();
    return new PaisDTO(found.get());
  }

}
//
