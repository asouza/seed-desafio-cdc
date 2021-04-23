package org.ecorp.casadocodigo.services;

import java.util.Optional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.AutorDTO;
import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.forms.AutorFormRequest;
import org.ecorp.casadocodigo.model.Autor;
import org.ecorp.casadocodigo.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

  @Autowired
  private AutorRepository repository;

  public AutorDTO create(@Valid AutorFormRequest autorForm) {

    Autor saved = repository.save(autorForm.map());
    return new AutorDTO(saved);

  }

  public AutorDTO buscaAutorById(Long id) {

    Optional<Autor> found = repository.findById(id);
    if (found.isEmpty()) {
      throw new ResourceNotFoundException();
    }
    return new AutorDTO(found.get());
  }



}
