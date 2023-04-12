package com.tiozao.cdd.loja.controller.extensions

import com.tiozao.cdd.loja.controller.model.AutorRequest
import com.tiozao.cdd.loja.controller.model.AutorResponse
import com.tiozao.cdd.loja.controller.model.CategoriaRequest
import com.tiozao.cdd.loja.controller.model.CategoriaResponse
import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.domain.model.CategoriaModel
import com.tiozao.cdd.loja.repository.entity.AutorEntity
import com.tiozao.cdd.loja.repository.entity.CategoriaEntity


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

fun CategoriaRequest.toDomain(): CategoriaModel = CategoriaModel(
    id = this.id,
    nome = this.nome
)

fun CategoriaModel.toResponse(): CategoriaResponse = CategoriaResponse(
    id = this.id!!,
    nome = this.nome!!
)