package br.com.rsfot.bookstore.author;

public record NewAuthorResponse(String name, String email, String description, String createdAt) {
    public NewAuthorResponse(Author author) {
        this(author.getName(),
                author.getEmail(),
                author.getDescription(),
                author.getCreatedAt().toString());
    }

}
