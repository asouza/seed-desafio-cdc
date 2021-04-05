package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.OrderItem;

import java.math.BigDecimal;

public class OrderItemResponse {

    private BookSummaryResponse book;
    private int quantity;
    private BigDecimal currentPrice;

    public OrderItemResponse(OrderItem orderItem) {
        this.book = new BookSummaryResponse(orderItem.getBook());
        this.quantity = orderItem.getQuantity();
        this.currentPrice = orderItem.getCurrentPrice();
    }

    public BookSummaryResponse getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }
}
