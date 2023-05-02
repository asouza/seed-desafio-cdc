package com.tiozao.cdd.loja.domain.model.validators

import com.tiozao.cdd.loja.domain.model.CompradorModel
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

class EstadoPaisValidoValidator: ConstraintValidator<EstadoPaisValido,CompradorModel>{

    @PersistenceContext
    lateinit var entityManager: EntityManager
    var fieldName: Array<KClass<Any>>? = null
    var classTarget: Array<KClass<Payload>>? = null

    override fun initialize(constraintAnnotation: EstadoPaisValido) {
        super.initialize(constraintAnnotation)
        fieldName = constraintAnnotation.groups
        classTarget = constraintAnnotation.payload
    }

    override fun isValid(value: CompradorModel, context: ConstraintValidatorContext?): Boolean {
        value.estadoId?.let {
            var query = entityManager.createQuery(
                "select count(*) from EstadoEntity e " +
                        " inner join PaisEntity p on e.pais.id = p.id " +
                        " where e.id = :estadoId AND p.id = :paisId ")
            query.setParameter("estadoId", value!!.estadoId!!)
            query.setParameter("paisId", value.paisId!!)
            var result = query!!.resultList
            return ( result[0] as Long)== 1L
        }.run{
            var query = entityManager.createQuery(
                " select count(*) from PaisEntity p " +
                        " left join EstadoEntity e on e.pais.id = p.id " +
                        " where p.id = :paisId ")
            query.setParameter("paisId", value.paisId)
            var result = query!!.resultList
            return ( result[0] as Long) == 1L
        }
    }

}
