package com.dev.eficiente.casa.codigo

import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import javax.persistence.*

@Entity(name = "autor")
data class Autor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "nome")
    val nome: String,
    @Column(name = "descricao")
    val descricao: String,
    @Column(name = "email")
    val email: String,
    @UpdateTimestamp
    @Column(name = "data_adicionada")
    val dataAdicionada: Instant)
