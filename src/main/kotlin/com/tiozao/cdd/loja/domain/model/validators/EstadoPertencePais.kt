package com.tiozao.cdd.loja.domain.model.validators

import com.tiozao.cdd.loja.domain.model.CarrinhoCompraModel
import com.tiozao.cdd.loja.repository.EstadoRepository
import com.tiozao.cdd.loja.repository.PaisRepository
import com.tiozao.cdd.loja.repository.entity.EstadoEntity
import com.tiozao.cdd.loja.repository.entity.PaisEntity
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator
import javax.persistence.EntityManager

@Component
class EstadoPertencePais(
   private var entityManager: EntityManager
): Validator {

    override fun supports(clazz: Class<*>): Boolean {
        return CarrinhoCompraModel::class.java.isAssignableFrom(clazz)
    }

    override fun validate(target: Any, errors: Errors) {
        if(errors.hasErrors()){
            return
        }
        var carrinhoCompra = target as CarrinhoCompraModel

        var pais = entityManager.find(PaisEntity::class.java, carrinhoCompra.comprador.paisId)
        pais?.let {
            carrinhoCompra.comprador.estadoId?.let { idEstado ->
                var estado = entityManager.find(EstadoEntity::class.java, idEstado)
                if( !estado.pais.equals(pais) ){
                    errors.rejectValue("comprador", "", "Estado nao pertence a este pais.")
                }
            }.run {
                if ( !pais.hasEstado ) {
                    errors.rejectValue("comprador", "", "obrigatorio definir um estado.");
                }
            }
        }.run {
            if(pais == null) {
                errors.rejectValue("comprador", "", "obrigatorio definir um pais.");
            }
        }
    }


}