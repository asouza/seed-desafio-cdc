package com.tiozao.cdd.loja.controller.extensions

import com.tiozao.cdd.loja.controller.model.*
import com.tiozao.cdd.loja.domain.model.*


fun AutorRequest.toDomain() : AutorModel = AutorModel(
    nome = this.nome,
    email = this.email,
    descricao = this.descricao
)

fun CategoriaRequest.toDomain(): CategoriaModel = CategoriaModel(
    id = this.id,
    nome = this.nome
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

fun PaisRequest.toModel(): PaisModel = PaisModel(
    id = null,
    nome = this.nome
)

fun EstadoRequest.toModel(paisNome: String) = EstadoModel(
    id = null,
    nome = this.nome,
    sigla = this.sigla,
    pais = PaisModel(
        id = null,
        nome = paisNome
    )
)

fun CompradorRequest.ToModel() = CompradorModel(
    email = this.email,
    nome = this.nome,
    sobrenome = this.sobrenome,
    documento = this.documento,
    endereco = this.endereco,
    complemento = this.complemento,
    cidade = this.cidade,
    pais = PaisModel(
        id = null,
        nome = this.pais
    ),
    estado = this.estado?.let {
        EstadoModel(
            id = null,
            nome = this.estado,
            sigla = null,
            pais = null
        ) } ,
    telefone = this.telefone,
    cep = this.cep
)
