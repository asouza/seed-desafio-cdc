package com.tiozao.cdd.loja.controller.model

import java.math.BigDecimal

data class CarrinhoCompraRequest (
    var total: BigDecimal,
    var itens: MutableList<Itens>
)