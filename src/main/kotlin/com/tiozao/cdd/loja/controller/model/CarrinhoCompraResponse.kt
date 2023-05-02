package com.tiozao.cdd.loja.controller.model

import java.math.BigDecimal

data class CarrinhoCompraResponse(
    var total: BigDecimal,
    var itens: MutableList<Itens>
)
