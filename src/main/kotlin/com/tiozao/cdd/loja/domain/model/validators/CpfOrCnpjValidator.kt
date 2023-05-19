package com.tiozao.cdd.loja.domain.model.validators

import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator
import java.util.regex.Pattern
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class CpfOrCnpjValidator: ConstraintValidator<CPF_OR_CNPJ,String> {

    var cpfValidator: CPFValidator = CPFValidator()
    var cnpjValidator: CNPJValidator = CNPJValidator()

    override fun initialize(constraintAnnotation: CPF_OR_CNPJ?) {
        super.initialize(constraintAnnotation)
        cpfValidator.initialize(CPF(message = "cpf invalido.", groups = arrayOf(), payload = arrayOf() ))
        cnpjValidator.initialize(CNPJ(message = "cnpj invalido.", groups = arrayOf(), payload = arrayOf() ))
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
       return cpfValidator.isValid(value, null) || cnpjValidator.isValid(value,null)
    }


}
