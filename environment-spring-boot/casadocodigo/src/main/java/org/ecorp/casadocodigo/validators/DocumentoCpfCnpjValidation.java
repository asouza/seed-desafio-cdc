package org.ecorp.casadocodigo.validators;

import org.ecorp.casadocodigo.forms.CompraFormRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class DocumentoCpfCnpjValidation implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return CompraFormRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {

    if (errors.hasErrors())
      return;

    CompraFormRequest request = (CompraFormRequest) target;

    if (!request.documentoValido()) {
      errors.rejectValue("documento", null, "documento precisa der um cpf ou cnpj valido");
    }

  }

}
