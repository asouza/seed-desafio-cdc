package com.tiozao.cdd.loja.controller.model

import java.time.LocalDateTime

data class AutorResponse(
    var id: Int,
    var nome: String,
    var email: String,
    var descricao: String?,
    var instante: LocalDateTime?
)