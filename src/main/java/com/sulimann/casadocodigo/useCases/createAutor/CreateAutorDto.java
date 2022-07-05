package com.sulimann.casadocodigo.useCases.createAutor;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sulimann.casadocodigo.entities.Autor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAutorDto {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    public Autor convertToAutorModel(){
        return new Autor(null, name, email, description, LocalDateTime.now(ZoneId.of("UTC")));
    }
    
}
