package com.tiozao.cdd.loja.controller.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

data class LivroResponse(
    var id: Int? = null,
    var titulo: String?,
    var sumario: String?,
    var resumo: String?,
    var preco: BigDecimal?,
    var numeroPaginas: Int?,
    var isbn: String,
    var dataPublicacao: LocalDate?,
    var categoria: CategoriaResponse,
    var autor: AutorResponse,
    var instante: LocalDateTime? = LocalDateTime.now()
)