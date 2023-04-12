package com.tiozao.cdd.loja.domain.model.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UnicValueValidator::class])
@MustBeDocumented
annotation class UnicValue(
    val message: String = "Categoria ja cadastrada.",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
    val fieldName: String,
    val classTarget: KClass<*>,
)
