package br.com.armando.decasadocodigo.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
public class OrderItem {

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal currentPrice;

    @Deprecated
    public OrderItem() {
    }

    public OrderItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
        this.currentPrice = book.getPrice();
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public BigDecimal total() {
        return currentPrice.multiply(BigDecimal.valueOf(quantity));
    }

}
