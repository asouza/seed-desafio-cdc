package com.tiozao.cdd.loja.domain.model.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [MinDateValidator::class])
@MustBeDocumented
annotation class MinDate(
    val message: String = "Data anterior a data atual.",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)
