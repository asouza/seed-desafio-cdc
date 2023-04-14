package com.tiozao.cdd.loja.repository.entity

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
@Entity
@Table( name = "livro" )
data class LivroEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @field:NotNull
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
    var isbn: String,
    var dataPublicacao: LocalDate?,
    @field:NotNull
    @field:ManyToOne
    var categoria: CategoriaEntity,
    @field:NotNull
    @field:ManyToOne
    var autor: AutorEntity,
    var instante: LocalDateTime? = LocalDateTime.now() )