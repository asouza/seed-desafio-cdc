package com.tiozao.cdd.loja.controller.model

data class CompradorResponse (
    var email: String,
    var nome: String,
    var sobrenome: String,
    var documento: String,
    var endereco: String,
    var complemento: String,
    var cidade: String,
    var pais: String,
    var estado: String?,
    var telefone: String,
    var cep: String )
