package com.tiozao.cdd.loja.domain.model.validators

import java.time.LocalDate
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class MinDateValidator: ConstraintValidator<MinDate, LocalDate> {
    override fun isValid(value: LocalDate?, context: ConstraintValidatorContext?): Boolean {
        value?.let { return LocalDate.now().isBefore(value) }
            .run { return true}
    }
}