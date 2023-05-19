package com.tiozao.cdd.loja.domain.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.tiozao.cdd.loja.domain.model.validators.MinDate
import com.tiozao.cdd.loja.domain.model.validators.UnicValue
import com.tiozao.cdd.loja.repository.entity.CupomEntity
import com.tiozao.cdd.loja.repository.entity.LivroEntity
import java.time.LocalDate
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class CupomModel(
    @field:NotNull
    @field:UnicValue(classTarget = CupomEntity::class, fieldName = "codigo")
    var codigo: String,
    @field:Min(0)
    var percent: Double,
    @field:MinDate
    @field:JsonFormat(pattern = "dd/MM/yyyy")
    var validade: LocalDate
)