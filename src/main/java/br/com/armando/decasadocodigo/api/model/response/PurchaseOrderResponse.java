package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.Order;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PurchaseOrderResponse {

    private Long id;
    private Set<OrderItemResponse> items = new HashSet<>();
    private BigDecimal total;

    public PurchaseOrderResponse(Order order) {
        this.id = order.getId();
        this.items = order.getItems().stream().map(orderItem -> new OrderItemResponse(orderItem)).collect(Collectors.toSet());
        this.total = order.calculateTotal();
    }

    public Long getId() {
        return id;
    }

    public Set<OrderItemResponse> getItems() {
        return items;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
