package com.tiozao.cdd.loja.domain.model.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UnicEstadoValidator::class])
@MustBeDocumented
annotation class UnicEstado(
    val message: String = "ja cadastrada(o).",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [])
