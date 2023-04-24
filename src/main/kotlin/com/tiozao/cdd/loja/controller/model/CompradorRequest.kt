package com.tiozao.cdd.loja.controller.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

data class CompradorRequest (
        @field:Email
        @field:NotNull
        var email: String,
        @field:NotNull
        var nome: String,
        @field:NotNull
        var sobrenome: String,
        @field:NotNull
        var documento: String,
        @field:NotNull
        var endereco: String,
        @field:NotNull
        var complemento: String,
        @field:NotNull
        var cidade: String,
        @field:NotNull
        var pais: String,
        var estado: String,
        @field:NotNull
        var telefone: String,
        @field:NotNull
        var cep: String )
