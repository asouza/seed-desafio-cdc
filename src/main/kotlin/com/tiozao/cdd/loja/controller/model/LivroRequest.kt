package com.tiozao.cdd.loja.controller.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.tiozao.cdd.loja.domain.model.AutorModel
import com.tiozao.cdd.loja.domain.model.CategoriaModel
import com.tiozao.cdd.loja.domain.model.validators.MinDate
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.ManyToOne
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class LivroRequest (
var id: Int? = null,
@field:NotNull
var titulo: String?,
@field:NotNull
@field:Size(max=500)
var resumo: String?,
var sumario: String?,
@DecimalMin(value = "20.0", inclusive = true)
var preco: BigDecimal?,
@field:Min(100)
var numeroPaginas: Int?,
@field:NotNull
@field:NotNull
var isbn: String,
@field:MinDate
@field:JsonFormat(pattern = "dd/MM/yyyy")
var dataPublicacao: LocalDate?,
@field:NotNull
var categoriaId: Int,
@field:NotNull
var autorId: Int,
var instante: LocalDateTime? = LocalDateTime.now())