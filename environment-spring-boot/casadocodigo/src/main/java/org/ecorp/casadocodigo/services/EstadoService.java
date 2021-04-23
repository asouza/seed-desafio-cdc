package org.ecorp.casadocodigo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.EstadoDTO;
import org.ecorp.casadocodigo.exceptions.ResourceNotFoundException;
import org.ecorp.casadocodigo.forms.EstadoFormRequest;
import org.ecorp.casadocodigo.model.Estado;
import org.ecorp.casadocodigo.model.Pais;
import org.ecorp.casadocodigo.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//5
@Service
public class EstadoService {

  @Autowired
  private EstadoRepository repository;

  @PersistenceContext
  private EntityManager entityManager;

  public EstadoDTO buscaPorID(Long id) {

    Optional<Estado> found = repository.findById(id);
    if (found.isEmpty())
      throw new ResourceNotFoundException();

    return new EstadoDTO(found.get());


  }

  public EstadoDTO criar(@Valid EstadoFormRequest request) {

    Estado estado = request.toModel(entityManager);
    estado = repository.save(estado);


    return new EstadoDTO(estado);
  }

  public List<EstadoDTO> buscaPorPaisID(Long paisID) {
    Pais pais = entityManager.find(Pais.class, paisID);
    List<Estado> findByPais = repository.findByPais(pais);
    return findByPais.stream().map(e -> new EstadoDTO(e)).collect(Collectors.toList());
  }



}
