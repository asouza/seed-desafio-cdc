package org.ecorp.casadocodigo.controllers;

import java.net.URI;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.CategoriaDTO;
import org.ecorp.casadocodigo.forms.CategoriaFormRequest;
import org.ecorp.casadocodigo.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/categorias")
public class CategoriaControllers {


  @Autowired
  private CategoriaService service;


  @PostMapping
  @Transactional
  public ResponseEntity<CategoriaDTO> createAutor(@Valid @RequestBody final CategoriaFormRequest autor,
      UriComponentsBuilder uriBuilder) {
    CategoriaDTO created = service.create(autor);

    URI uri = uriBuilder.path("/autor/{id}").buildAndExpand(created.getCategoriaID()).toUri();
    return ResponseEntity.created(uri).body(created);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoriaDTO> detalheAutor(@PathVariable Long id) {
    return ResponseEntity.ok(service.buscaCategoriaById(id));
  }


}
