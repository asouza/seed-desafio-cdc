package org.ecorp.casadocodigo.validators;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ecorp.casadocodigo.forms.CompraFormRequest;
import org.ecorp.casadocodigo.model.Estado;
import org.ecorp.casadocodigo.model.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class EstadoPertenceAPaisValidation implements org.springframework.validation.Validator {

  @PersistenceContext
  private EntityManager manager;

  @Override
  public boolean supports(Class<?> clazz) {
    return CompraFormRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    CompraFormRequest compra = (CompraFormRequest) target;
    if (errors.hasErrors() || compra.getEstadoID() == null)
      return;


    Pais foundPais = manager.find(Pais.class, compra.getPaisID());
    Estado foundEstado = manager.find(Estado.class, compra.getEstadoID());

    if (!foundEstado.pertence(foundPais))
      errors.rejectValue("EstadoID", null, "Este estado não é o do pais selecionado");
  }


}
