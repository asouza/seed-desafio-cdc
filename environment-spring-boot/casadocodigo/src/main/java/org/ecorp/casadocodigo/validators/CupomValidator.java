package org.ecorp.casadocodigo.validators;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.ecorp.casadocodigo.model.Cupom;

public class CupomValidator implements ConstraintValidator<CupomValido, String> {


  @PersistenceContext
  private EntityManager manager;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {

    if (value == null) {
      return true;
    }

    Cupom find = manager.find(Cupom.class, value);
    return LocalDate.now().compareTo(find.getValidade()) <= 0;
  }


}
