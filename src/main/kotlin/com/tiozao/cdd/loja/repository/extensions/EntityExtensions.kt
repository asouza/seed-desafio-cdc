package com.tiozao.cdd.loja.repository.extensions

import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.domain.model.CategoriaModel
import com.tiozao.cdd.loja.repository.entity.AutorEntity
import com.tiozao.cdd.loja.repository.entity.CategoriaEntity

fun AutorModel.toEntity(): AutorEntity = AutorEntity(
    id = this.id,
    nome = this.nome,
    email = this.email,
    descricao = this.descricao,
    instante = this.instante
)

fun AutorEntity.toModel(): AutorModel = AutorModel(
    id = this.id,
    nome = this.nome,
    email = this.email,
    descricao = this.descricao,
    instante = this.instante
)

fun CategoriaEntity.toModel(): CategoriaModel = CategoriaModel(
    id = this.id,
    nome = this.nome
)

fun CategoriaModel.toEntity(): CategoriaEntity = CategoriaEntity(
    id = this.id,
    nome = this.nome
)

