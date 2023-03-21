package com.tiozao.cdd.loja.controller.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated

data class AutorRequest(
    @field:NotNull
    var nome: String,
    @field:Email
    var email: String,
    @field:Size(max=400)
    var descricao: String?
)