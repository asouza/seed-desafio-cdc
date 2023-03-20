package com.tiozao.cdd.loja.controller.model

import org.jetbrains.annotations.NotNull
import java.time.LocalDateTime

data class AutorResponse(
    var id: Int,
    @NotNull
    var nome: String,
    @NotNull
    var email: String,
    var descricao: String?,
    var instante: LocalDateTime?
)