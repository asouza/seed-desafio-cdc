package br.com.rsfot.bookstore.author;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record NewAuthorRequest(
        @NotBlank
        String name,
        @NotNull
        @Email
        String email,
        @Size(max = 400)
        String description,
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt) {
    public Author toModel() {
        return new Author(name, email, description, createdAt);
    }
}
