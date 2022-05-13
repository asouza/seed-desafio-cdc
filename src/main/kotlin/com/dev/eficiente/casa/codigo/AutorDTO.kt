package com.dev.eficiente.casa.codigo

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class AutorDTO(
    @field:NotBlank(message = "O nome é obrigatorio")
     val nome: String,
    @field:Size(max = 400, message = "A descrição não pode passar de 400 ")
    @field:NotBlank
     val descricao: String,
    @field:NotBlank(message = "O email é obrigatorio.")
    @field:Email
     val email: String
)