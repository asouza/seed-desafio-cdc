package com.tiozao.cdd.loja.controller.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


data class AutorRequest(
    @field:NotNull
    var nome: String,
    @field:Email
    var email: String,
    @field:Size(max=400)
    var descricao: String?
)