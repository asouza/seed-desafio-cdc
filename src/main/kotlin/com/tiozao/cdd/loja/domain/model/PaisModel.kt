package com.tiozao.cdd.loja.domain.model

import com.tiozao.cdd.loja.domain.model.validators.UnicValue
import com.tiozao.cdd.loja.repository.entity.PaisEntity

data class PaisModel (
    var id: Int?,
    @UnicValue(classTarget = PaisEntity::class, fieldName = "nome")
    var nome: String?,
    var hasEstado: Boolean
    )