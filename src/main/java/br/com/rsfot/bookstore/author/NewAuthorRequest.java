package br.com.rsfot.bookstore.author;

import jakarta.validation.constraints.*;

public record NewAuthorRequest(
        @NotBlank
        String name,
        @NotNull
        @Email
        String email,
        @Size(max = 400)
        String description) {
    public Author toModel() {
        return new Author(name, email, description);
    }
}
