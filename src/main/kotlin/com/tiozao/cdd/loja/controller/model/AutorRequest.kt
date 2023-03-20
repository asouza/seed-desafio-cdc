package com.tiozao.cdd.loja.controller.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import org.springframework.validation.annotation.Validated

data class AutorRequest(
    @field:NotNull
    var nome: String,
    @field:Email
    var email: String,
    @field:Max(400)
    var descricao: String?
)