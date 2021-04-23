package org.ecorp.casadocodigo.controllers;

import java.net.URI;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.EstadoDTO;
import org.ecorp.casadocodigo.forms.EstadoFormRequest;
import org.ecorp.casadocodigo.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

// 3
@RestController
@RequestMapping("/estados")
public class EstadoController {


  @Autowired
  private EstadoService service;

  @GetMapping("{id}")
  public ResponseEntity<EstadoDTO> buscaEstadoPorID(@PathVariable final Long id) {
    EstadoDTO dto = service.buscaPorID(id);
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<EstadoDTO> criarPais(@Valid @RequestBody final EstadoFormRequest request,
      UriComponentsBuilder builder) {
    EstadoDTO dto = service.criar(request);
    URI location = builder.path("/estados/{id}").buildAndExpand(dto.getEstadoID()).toUri();
    return ResponseEntity.created(location).body(dto);
  }



  @GetMapping
  public ResponseEntity<List<EstadoDTO>> buscaEstadoPais(
      @RequestParam(value = "paisid") final Long paisID) {
    List<EstadoDTO> dto = service.buscaPorPaisID(paisID);
    return ResponseEntity.ok(dto);
  }


}
