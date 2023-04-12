package com.tiozao.cdd.loja.controller.model

import javax.validation.constraints.NotNull

data class CategoriaRequest (
    var id: Int?,
    @field:NotNull
    var nome: String )