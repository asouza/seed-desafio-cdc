package com.tiozao.cdd.loja.repository.entity

import javax.persistence.*

@Entity
@Table(name = "pais")
data class PaisEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var nome: String?,
    var hasEstado: Boolean)

