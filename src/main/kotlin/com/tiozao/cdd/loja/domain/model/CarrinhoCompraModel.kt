package com.tiozao.cdd.loja.domain.model

import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class CarrinhoCompraModel (
    var id: Int?,
    @field:NotNull
    var comprador: CompradorModel,
    @field:NotNull
    var total: BigDecimal?,
    @field:NotNull
    var itens: MutableList<ItensModel>
  )

