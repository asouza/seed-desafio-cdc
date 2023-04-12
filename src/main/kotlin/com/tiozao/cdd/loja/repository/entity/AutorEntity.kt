package com.tiozao.cdd.loja.repository.entity

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "autor")
data class AutorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @field:NotNull
    var nome: String?,
    @field:Email
    @field:Column(unique = true)
    var email: String?,
    @field:Size(max=400)
    var descricao: String?,
    var instante: LocalDateTime? = LocalDateTime.now()
) {
    constructor(): this( null, null, null, null)
}
