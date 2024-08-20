package com.cdc.autor;

import jakarta.validation.constraints.*;

public record NovoAutorRequest(@NotBlank String nome,
                               @Email String email,
                               @NotBlank @Size(max = 400) String descricao) {

    public Autor toModel() {
        return new Autor(nome, email, descricao);
    }
}
