package com.tiozao.cdd.loja.domain.model

import com.tiozao.cdd.loja.domain.model.validators.UnicValue
import com.tiozao.cdd.loja.repository.entity.CategoriaEntity
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class CategoriaModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    @field:UnicValue(fieldName = "nome", classTarget = CategoriaEntity::class, message = "Categoria ja existente.")
    @field:Column(nullable = false)
    var nome: String?
)