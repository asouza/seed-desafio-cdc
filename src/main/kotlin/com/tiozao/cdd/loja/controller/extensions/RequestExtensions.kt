package com.tiozao.cdd.loja.controller.extensions

import com.tiozao.cdd.loja.controller.model.*
import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.domain.model.CategoriaModel
import com.tiozao.cdd.loja.domain.model.LivroModel
import com.tiozao.cdd.loja.domain.service.AutorService
import com.tiozao.cdd.loja.domain.service.CategoriaService
import com.tiozao.cdd.loja.repository.entity.AutorEntity
import com.tiozao.cdd.loja.repository.entity.CategoriaEntity
import com.tiozao.cdd.loja.repository.extensions.toModel
import org.springframework.beans.factory.annotation.Autowired


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

fun LivroModel.toResponse(categoriaResponse: CategoriaResponse,
                          autorResponse: AutorResponse): LivroResponse = LivroResponse(
    id = this.id,
    titulo = this.titulo,
    resumo = this.resumo,
    sumario =  this.sumario,
    preco =  this.preco,
    numeroPaginas = this.numeroPaginas,
    isbn = this.isbn,
    dataPublicacao=this.dataPublicacao,
    categoria = categoriaResponse,
    autor = autorResponse,
    instante = this.instante
)

fun LivroRequest.toModel(): LivroModel = LivroModel(
    id = this.id,
    titulo = this.titulo,
    resumo = this.resumo,
    sumario =  this.sumario,
    preco =  this.preco,
    numeroPaginas = this.numeroPaginas,
    isbn = this.isbn,
    dataPublicacao=this.dataPublicacao,
    categoriaId = this.categoriaId,
    autorId = this.autorId,
    instante = this.instante
)