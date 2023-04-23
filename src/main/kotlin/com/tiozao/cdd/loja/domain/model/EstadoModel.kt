package com.tiozao.cdd.loja.domain.model

import com.tiozao.cdd.loja.domain.model.validators.UnicEstado

@UnicEstado
data class EstadoModel (
    var id: Int?,
    var nome: String?,
    var sigla: String?,
    var pais: PaisModel? )
