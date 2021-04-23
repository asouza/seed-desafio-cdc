package org.ecorp.casadocodigo.services;

import java.util.Optional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.CategoriaDTO;
import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.forms.CategoriaFormRequest;
import org.ecorp.casadocodigo.model.Categoria;
import org.ecorp.casadocodigo.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {


  @Autowired
  private CategoriaRepository repository;

  public CategoriaDTO create(@Valid CategoriaFormRequest categoriaForm) {

    Categoria saved = repository.save(categoriaForm.map());
    return new CategoriaDTO(saved);

  }

  public CategoriaDTO buscaCategoriaById(Long id) {

    Optional<Categoria> found = repository.findById(id);
    if (found.isEmpty()) {
      throw new ResourceNotFoundException();
    }
    return new CategoriaDTO(found.get());
  }

}
