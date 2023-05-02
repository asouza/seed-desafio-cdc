package com.tiozao.cdd.loja.controller.model

data class CompradorResponse (
    var id: Int?,
    var email: String,
    var nome: String,
    var sobrenome: String,
    var documento: String,
    var endereco: String,
    var complemento: String,
    var cidade: String,
    var paisId: Int,
    var estadoId: Int?,
    var telefone: String?,
    var cep: String ?)
