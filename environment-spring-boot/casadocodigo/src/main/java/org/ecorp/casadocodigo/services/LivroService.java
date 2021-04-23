package org.ecorp.casadocodigo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.ItemListLivroDTO;
import org.ecorp.casadocodigo.dtos.LivroDTO;
import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.forms.LivroFormRequest;
import org.ecorp.casadocodigo.model.Livro;
import org.ecorp.casadocodigo.repositories.AutorRepository;
import org.ecorp.casadocodigo.repositories.CategoriaRepository;
import org.ecorp.casadocodigo.repositories.LivroRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 7
@Service
public class LivroService {

  // 1
  @Autowired
  private LivroRespository repository;

  // 1
  @Autowired
  private AutorRepository autorRepository;

  // 1
  @Autowired
  private CategoriaRepository categoriaRepository;

  public LivroDTO buscaAutorById(Long id) {
    Optional<Livro> found = repository.findById(id);
    // 1
    if (found.isEmpty()) {
      throw new ResourceNotFoundException();
    }

    return new LivroDTO(found.get());
  }

  // 1
  public LivroDTO create(@Valid LivroFormRequest livroRequest) {

    Livro livro = livroRequest.toModel(autorRepository, categoriaRepository);
    livro = repository.save(livro);
    return new LivroDTO(livro);
  }

  public List<ItemListLivroDTO> getList() {

    return repository.findAll()
        .stream()
        .map(livro -> new ItemListLivroDTO(livro))
        .collect(Collectors.toList());
    
  }

}
