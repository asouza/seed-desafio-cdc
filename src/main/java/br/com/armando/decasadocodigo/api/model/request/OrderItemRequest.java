package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.ExistsId;
import br.com.armando.decasadocodigo.domain.model.Book;
import br.com.armando.decasadocodigo.domain.model.OrderItem;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class OrderItemRequest {

    @NotNull
    @ExistsId(domainClass = Book.class, fieldName = "id")
    private Long bookId;

    @Positive
    private int quantity;

    public OrderItemRequest(@NotNull @ExistsId(domainClass = Book.class, fieldName = "id") Long bookId, @Positive int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public Long getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderItem toModel(EntityManager manager) {
        Book book = manager.find(Book.class, bookId);
        return new OrderItem(book, quantity);
    }
}
