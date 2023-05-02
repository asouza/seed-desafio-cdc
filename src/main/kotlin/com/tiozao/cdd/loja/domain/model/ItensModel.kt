package com.tiozao.cdd.loja.domain.model

import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ItensModel (
    @field:NotNull
    var idLivro: Int,
    @field:Positive
    var quantidade: Int )
