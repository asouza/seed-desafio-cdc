package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.UniqueValue;
import br.com.armando.decasadocodigo.domain.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank
    private String name;

    @UniqueValue(domainClass = Author.class, fieldName = "email")
    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;

    public AuthorRequest(
            @NotBlank String name,
            @UniqueValue(domainClass = Author.class, fieldName = "email") @NotBlank @Email String email,
            @NotBlank @Size(max = 400) String description
    ) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author toModel() {
        Author author = new Author(
                this.name,
                this.email,
                this.description
        );
        return author;
    }

    public String getEmail() {
        return this.email;
    }

}
