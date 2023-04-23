package com.tiozao.cdd.loja.repository.extensions

import com.tiozao.cdd.loja.domain.model.*
import com.tiozao.cdd.loja.domain.service.AutorService
import com.tiozao.cdd.loja.domain.service.CategoriaService
import com.tiozao.cdd.loja.repository.entity.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EntityExtensions(){
    @Autowired
    lateinit var categoriaService: CategoriaService
    @Autowired
    lateinit var autorService: AutorService

}

fun LivroModel.toEntity(
    categoriaEntity: CategoriaEntity,
    autorEntity: AutorEntity): LivroEntity = LivroEntity(
    id = this.id,
    titulo = this.titulo,
    resumo = this.resumo,
    sumario =  this.sumario,
    preco =  this.preco,
    numeroPaginas = this.numeroPaginas,
    isbn = this.isbn,
    dataPublicacao=this.dataPublicacao,
    categoria = categoriaEntity,
    autor = autorEntity,
    instante = this.instante
)
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

fun LivroEntity.toModel(): LivroModel = LivroModel(
    id = this.id,
    titulo = this.titulo,
    resumo = this.resumo,
    sumario =  this.sumario,
    preco =  this.preco,
    numeroPaginas = this.numeroPaginas,
    isbn = this.isbn,
    dataPublicacao=this.dataPublicacao,
    categoriaId = this.categoria.id!!,
    autorId = this.autor.id!!,
    instante = this.instante
)

fun PaisModel.toEntity() = PaisEntity(
    id = this.id,
    nome = this.nome,
    estados = this.estados.map { it.toEntity() }.toMutableList()
)

fun PaisEntity.toModel() = PaisModel(
    id =this.id,
    nome = this.nome,
    estados = this.estados.map { it.toModel() }.toMutableList()
)

fun EstadoEntity.toModel() = EstadoModel(
    id = this.id,
    nome = this.nome,
    sigla = this.sigla,
    pais = PaisModel(
        id = this.pais.id,
        nome = this.pais.nome )
)

fun EstadoModel.toEntity() = EstadoEntity(
    id = this.id,
    nome = this.nome,
    sigla = this.sigla,
    pais = PaisEntity(
        id = this.pais?.id,
        nome = this.pais?.nome )
)