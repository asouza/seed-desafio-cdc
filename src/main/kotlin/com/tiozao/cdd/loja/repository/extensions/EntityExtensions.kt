package com.tiozao.cdd.loja.repository.extensions

import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.domain.model.CategoriaModel
import com.tiozao.cdd.loja.domain.model.LivroModel
import com.tiozao.cdd.loja.domain.service.AutorService
import com.tiozao.cdd.loja.domain.service.CategoriaService
import com.tiozao.cdd.loja.repository.entity.AutorEntity
import com.tiozao.cdd.loja.repository.entity.CategoriaEntity
import com.tiozao.cdd.loja.repository.entity.LivroEntity
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