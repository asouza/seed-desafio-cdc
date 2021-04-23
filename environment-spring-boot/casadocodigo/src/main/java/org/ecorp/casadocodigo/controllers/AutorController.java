package org.ecorp.casadocodigo.controllers;

import java.net.URI;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.AutorDTO;
import org.ecorp.casadocodigo.forms.AutorFormRequest;
import org.ecorp.casadocodigo.services.AutorService;
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
@RequestMapping("/autores")
public class AutorController {

  @Autowired
  private AutorService service;

  @PostMapping
  @Transactional
  public ResponseEntity<AutorDTO> createAutor(@Valid @RequestBody final AutorFormRequest autor,
      UriComponentsBuilder builder) {

    AutorDTO created = service.create(autor);

    URI uri = builder.path("/autores/{id}").buildAndExpand(created.getAutorID()).toUri();
    return ResponseEntity.created(uri).body(created);
  }


  @GetMapping("/{id}")
  public ResponseEntity<AutorDTO> detalheAutor(@PathVariable Long id) {
    return ResponseEntity.ok(service.buscaAutorById(id));
  }

}
