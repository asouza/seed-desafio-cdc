package com.tiozao.cdd.loja.controller.extensions

import com.tiozao.cdd.loja.controller.model.AutorRequest
import com.tiozao.cdd.loja.controller.model.AutorResponse
import com.tiozao.cdd.loja.domain.model.AutorModel


fun AutorRequest.toDomain() : AutorModel = AutorModel(
    nome = this.nome,
    email = this.email,
    descricao = this.descricao
)

fun AutorModel.toResponse(): AutorResponse = AutorResponse(
    id = this.id!!,
    nome = this.nome!!,
    email = this.email!!,
    descricao = this.descricao,
    instante = this.instante
)