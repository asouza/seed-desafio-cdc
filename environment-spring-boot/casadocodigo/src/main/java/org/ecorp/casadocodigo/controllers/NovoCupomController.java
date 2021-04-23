package org.ecorp.casadocodigo.controllers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.ecorp.casadocodigo.forms.NovoCupomRequest;
import org.ecorp.casadocodigo.model.Cupom;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoCupomController {

  @PersistenceContext
  private EntityManager manager;

  @PostMapping(value = "/cupom")
  @Transactional
  public String cria(@RequestBody @Valid NovoCupomRequest request) {

    Cupom novoCupom = request.toModel();
    manager.persist(novoCupom);
    return novoCupom.toString();

  }
}
