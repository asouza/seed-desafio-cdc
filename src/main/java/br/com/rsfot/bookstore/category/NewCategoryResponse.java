package br.com.rsfot.bookstore.category;

public record NewCategoryResponse(String name) {
    public NewCategoryResponse(Category category) {
        this(category.getName());
    }
}
