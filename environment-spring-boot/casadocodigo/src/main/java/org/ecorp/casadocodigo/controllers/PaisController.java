package org.ecorp.casadocodigo.controllers;

import java.net.URI;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.PaisDTO;
import org.ecorp.casadocodigo.forms.PaisFormRequest;
import org.ecorp.casadocodigo.services.PaisService;
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
@RequestMapping("/paises")
public class PaisController {

  @Autowired
  private PaisService service;

  @PostMapping
  @Transactional
  public ResponseEntity<PaisDTO> criarPais(@Valid @RequestBody final PaisFormRequest paisRequest,
      UriComponentsBuilder builder) {
    PaisDTO dto = service.criar(paisRequest);
    URI location = builder.path("/paises/{id}").buildAndExpand(dto.getPaisID()).toUri();
    return ResponseEntity.created(location).body(dto);
  }


  @GetMapping("{id}")
  public ResponseEntity<PaisDTO> detalhePais(@PathVariable final Long id) {
    return ResponseEntity.ok(service.buscaPorId(id));

  }


}
