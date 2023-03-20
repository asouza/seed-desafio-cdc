package com.tiozao.cdd.loja.domain.model


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.springframework.validation.annotation.Validated
import java.time.LocalDateTime



@Entity(name = "autor")
data class AutorModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,
    @field:NotNull
    var nome: String?,
    @field:Email
    var email: String?,
    @field:Size(min=0,max=400)
    var descricao: String?,
    var instante: LocalDateTime? = LocalDateTime.now()
) {
    constructor(): this( null, null, null, null)
}
