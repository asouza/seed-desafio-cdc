package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.Author;

import java.time.OffsetDateTime;

public class AuthorResponse {

    private Long id;
    private String name;
    private String email;
    private String description;
    private OffsetDateTime createdAt;

    public AuthorResponse(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.email = author.getEmail();
        this.description = author.getDescription();
        this.createdAt = author.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

}
