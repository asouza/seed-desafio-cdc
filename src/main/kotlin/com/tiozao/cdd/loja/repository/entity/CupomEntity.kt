package com.tiozao.cdd.loja.repository.entity

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "cupom")
data class CupomEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    var codigo: String,
    var percent: Double,
    var validade: LocalDate )