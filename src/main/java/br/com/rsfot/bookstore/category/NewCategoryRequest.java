package br.com.rsfot.bookstore.category;

import jakarta.validation.constraints.NotNull;

public record NewCategoryRequest(
        @NotNull
        String name) {

    public Category toModel() {
        return new Category(name);
    }
}
