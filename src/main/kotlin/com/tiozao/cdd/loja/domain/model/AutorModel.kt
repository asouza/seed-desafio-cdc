package com.tiozao.cdd.loja.domain.model

import com.tiozao.cdd.loja.domain.model.validators.UnicValue
import com.tiozao.cdd.loja.repository.entity.AutorEntity
import java.time.LocalDateTime
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class AutorModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @field:NotNull
    var nome: String?,
    @field:Email
    @field:UnicValue(fieldName = "email", classTarget = AutorEntity::class, message = "Autor ja cadastrado com email.")
    var email: String?,
    @field:Size(max=400)
    var descricao: String?,
    var instante: LocalDateTime? = LocalDateTime.now()
)