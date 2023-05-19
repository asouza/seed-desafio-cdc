package com.tiozao.cdd.loja.domain.model.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [CpfOrCnpjValidator::class])
@MustBeDocumented
annotation class CPF_OR_CNPJ (
    val message: String = "DocumentoInvalido.",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []){

}