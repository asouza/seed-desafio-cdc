package org.ecorp.casadocodigo.validators;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;


public class ExistsIDValidator implements ConstraintValidator<ExistsID, Object> {

  private String fieldName;
  private Class<?> domainClass;

  @PersistenceContext
  private EntityManager manager;

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {

    if (value == null) {
      return true;
    }



    Query query = manager.createQuery(
        "SELECT 1 FROM " + this.domainClass.getName() + " WHERE " + this.fieldName + "=:value");
    query.setParameter("value", value);
    List<?> list = query.getResultList();

    Assert.state(list.size() <= 1, "Foi encontrado mais de um " + this.domainClass
        + "com o mesmo attributo " + fieldName + " value");
    return !list.isEmpty();
  }

  @Override
  public void initialize(ExistsID constraintAnnotation) {
    this.fieldName = constraintAnnotation.fieldName();
    this.domainClass = constraintAnnotation.domainClass();
  }

}
