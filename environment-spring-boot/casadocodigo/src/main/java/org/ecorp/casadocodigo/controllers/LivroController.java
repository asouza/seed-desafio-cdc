package org.ecorp.casadocodigo.controllers;

import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.ItemListLivroDTO;
import org.ecorp.casadocodigo.dtos.LivroDTO;
import org.ecorp.casadocodigo.forms.LivroFormRequest;
import org.ecorp.casadocodigo.services.LivroService;
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
@RequestMapping("/livros")
public class LivroController {

  @Autowired
  private LivroService service;

  @GetMapping("/{id}")
  public ResponseEntity<LivroDTO> detalheAutor(@PathVariable Long id) {
    return ResponseEntity.ok(service.buscaAutorById(id));
  }

  @PostMapping
  @Transactional
  public ResponseEntity<LivroDTO> createAutor(
      @Valid @RequestBody final LivroFormRequest livroRequest, UriComponentsBuilder builder) {

    LivroDTO created = service.create(livroRequest);

    URI uri = builder.path("/autores/{id}").buildAndExpand(created.getLivroID()).toUri();
    return ResponseEntity.created(uri).body(created);
  }

  @GetMapping(value = "/")
  public ResponseEntity<List<ItemListLivroDTO>> getMethodName() {
    return ResponseEntity.ok(service.getList());
  }


}
