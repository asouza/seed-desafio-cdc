package com.tiozao.cdd.loja.domain.model.validators

import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass


@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [AutorEmailValidator::class])
@MustBeDocumented
annotation class AutorEmail(
    val message: String = "Email ja cadastrado.",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []
)
