package com.tiozao.cdd.loja.domain.model.validators

import com.tiozao.cdd.loja.domain.model.EstadoModel
import org.springframework.stereotype.Component
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@Component
class UnicEstadoValidator: ConstraintValidator<UnicEstado, EstadoModel> {

    @PersistenceContext
    lateinit var entityManager: EntityManager
    var fieldName: Array<KClass<Any>>? = null
    var classTarget: Array<KClass<Payload>>? = null

    override fun initialize(constraintAnnotation: UnicEstado) {
        super.initialize(constraintAnnotation)
        fieldName = constraintAnnotation.groups
        classTarget = constraintAnnotation.payload
    }

    override fun isValid(value: EstadoModel?, context: ConstraintValidatorContext?): Boolean {
        var query = entityManager.createQuery(
             "select count(*) from EstadoEntity e " +
                    "inner join PaisEntity p on e.pais.id = p.id " +
                    "where e.nome = :estadoNome AND p.nome = :paisNome ")
        query.setParameter("estadoNome", value!!.nome)
        query.setParameter("paisNome", value.pais!!.nome)
        var result = query.resultList
        return ( result[0] as Long)== 0L
    }


}