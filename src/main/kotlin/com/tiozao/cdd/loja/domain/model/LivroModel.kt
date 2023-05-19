package com.tiozao.cdd.loja.domain.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.tiozao.cdd.loja.domain.model.validators.MinDate
import com.tiozao.cdd.loja.domain.model.validators.UnicValue
import com.tiozao.cdd.loja.repository.entity.LivroEntity
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LivroModel (
    var id: Int? = null,
    @field:NotNull
    @field:UnicValue(fieldName = "titulo", classTarget = LivroEntity::class)
    var titulo: String?,
    @field:NotNull
    @field:Size(max=500)
    var resumo: String?,
    @field:Lob
    var sumario: String?,
    @DecimalMin(value = "20.0", inclusive = true)
    var preco: BigDecimal?,
    @field:Min(100)
    var numeroPaginas: Int?,
    @field:NotNull
    @field:UnicValue(fieldName = "isbn", classTarget = LivroEntity::class)
    var isbn: String,
    @field:MinDate
    @field:JsonFormat(pattern = "dd/MM/yyyy")
    var dataPublicacao: LocalDate?,
    @field:NotNull
    var categoriaId: Int,
    @field:NotNull
    var autorId: Int,
    var instante: LocalDateTime? = LocalDateTime.now()
)