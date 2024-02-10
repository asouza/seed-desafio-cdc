package br.com.rsfot.bookstore.error.handler;

public class CategoryDuplicatedException extends RuntimeException{
    public CategoryDuplicatedException(String categoryName) {
        super("Category %s already exists".formatted(categoryName));
    }
}
