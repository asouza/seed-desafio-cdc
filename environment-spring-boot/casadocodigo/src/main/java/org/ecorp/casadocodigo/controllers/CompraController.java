package org.ecorp.casadocodigo.controllers;

import java.net.URI;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.dtos.CompraDTO;
import org.ecorp.casadocodigo.forms.CompraFormRequest;
import org.ecorp.casadocodigo.services.CompraService;
import org.ecorp.casadocodigo.validators.DocumentoCpfCnpjValidation;
import org.ecorp.casadocodigo.validators.EstadoPertenceAPaisValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/compra")
public class CompraController {


  private static final Logger log = LoggerFactory.getLogger(CompraController.class);


  @Autowired
  private CompraService service;

  @Autowired
  private EstadoPertenceAPaisValidation estadoPertenceAPaisValidation;

  @Autowired
  private DocumentoCpfCnpjValidation documentoCpfCnpjValidation;



  @InitBinder
  public void init(WebDataBinder binder) {
    binder.addValidators(documentoCpfCnpjValidation, estadoPertenceAPaisValidation);
  }


  @PostMapping()
  @Transactional
  public ResponseEntity<CompraDTO> postMethodName(@RequestBody @Valid CompraFormRequest compraForm,
      UriComponentsBuilder builder) {
    CompraDTO compra = service.realizaCompra(compraForm);
    URI location = builder.path("/compra/{id}").buildAndExpand("1").toUri();
    return ResponseEntity.created(location).body(compra);
  }



}
