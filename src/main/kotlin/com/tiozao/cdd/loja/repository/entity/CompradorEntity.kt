package com.tiozao.cdd.loja.repository.entity

import com.tiozao.cdd.loja.domain.model.EstadoModel
import com.tiozao.cdd.loja.domain.model.PaisModel
import com.tiozao.cdd.loja.domain.model.validators.CPF_OR_CNPJ
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity
@Table(name = "comprador")
data class CompradorEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int?,
        @field:Email
        @field:NotNull
        var email: String,
        @field:NotNull
        var nome: String,
        @field:NotNull
        var sobrenome: String,
        @field:CPF_OR_CNPJ
        var documento: String,
        @field:NotNull
        var endereco: String,
        @field:NotNull
        var complemento: String,
        @field:NotNull
        var cidade: String,
        @field:NotNull
        @ManyToOne
        var pais: PaisEntity,
        @ManyToOne
        var estado: EstadoEntity?,
        @field:NotNull
        var telefone: String?,
        @field:NotNull
        var cep: String? )
