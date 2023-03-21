package com.tiozao.cdd.loja.domain.model.validators

import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.repository.AutorRepository
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext

class AutorEmailValidator(private var repository: AutorRepository): ConstraintValidator<AutorEmail,String> {
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        return value.isNullOrBlank() || !repository.findByEmail(value).isPresent
    }

}
