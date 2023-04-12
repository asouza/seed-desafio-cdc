package com.tiozao.cdd.loja.domain.model.validators

import org.springframework.stereotype.Component
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

@Component
class UnicValueValidator: ConstraintValidator<UnicValue,String> {

    @PersistenceContext
    lateinit var entityManager: EntityManager
    var fieldName: String? = null
    var classTarget: KClass<*>? = null

    override fun initialize(constraintAnnotation: UnicValue?) {
        super.initialize(constraintAnnotation)
        fieldName = constraintAnnotation!!.fieldName
        classTarget = constraintAnnotation!!.classTarget
    }

    override fun isValid(value: String, context: ConstraintValidatorContext?): Boolean {
        var query = entityManager.createQuery("select count(*) from ${classTarget!!.simpleName} c where c.$fieldName = :value ")
        query.setParameter("value", value)
        var result = query.resultList
        return (result[0] as Int == 0)
    }
}