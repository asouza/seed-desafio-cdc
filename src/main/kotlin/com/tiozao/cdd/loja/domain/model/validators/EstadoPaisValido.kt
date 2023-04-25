package com.tiozao.cdd.loja.domain.model.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [EstadoPaisValidoValidator::class])
@MustBeDocumented
annotation class EstadoPaisValido(val message: String = "obrigatorio estado.",
                                  val groups: Array<KClass<Any>> = [],
                                  val payload: Array<KClass<Payload>> = [])