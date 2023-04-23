package com.tiozao.cdd.loja.controller.extensions

import com.tiozao.cdd.loja.controller.model.*
import com.tiozao.cdd.loja.domain.model.*

fun AutorModel.toResponse(): AutorResponse = AutorResponse(
    id = this.id!!,
    nome = this.nome!!,
    email = this.email!!,
    descricao = this.descricao,
    instante = this.instante
)

fun CategoriaModel.toResponse(): CategoriaResponse = CategoriaResponse(
    id = this.id!!,
    nome = this.nome!!
)

fun LivroModel.toResponse(categoriaResponse: CategoriaResponse,
                          autorResponse: AutorResponse
): LivroResponse = LivroResponse(
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

fun PaisModel.toResponse() = PaisResponse(
    nome = this.nome
)

fun EstadoModel.toResponse() = EstadoResponse(
    id = this.id,
    nome = this.nome,
    sigla = this.sigla
)