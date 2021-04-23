package org.ecorp.casadocodigo.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE,
    ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CupomValidator.class)
@Documented
public @interface CupomValido {



  String message() default "Cupom Vencido";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
      ElementType.ANNOTATION_TYPE})
  @Retention(RetentionPolicy.RUNTIME)
  @Documented
  @interface List {
    CupomValido[] value();
  }
}
