package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.domain.model.Order;
import br.com.armando.decasadocodigo.domain.model.OrderItem;
import br.com.armando.decasadocodigo.domain.model.Purchase;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderRequest {

    @NotNull
    @Positive
    private BigDecimal total;

    @Size(min = 1)
    @NotNull
    @Valid
    private List<OrderItemRequest> items;

    public OrderRequest(@NotNull @Positive BigDecimal total, @NotNull @Valid List<OrderItemRequest> items) {
        this.total = total;
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<OrderItemRequest> getItems() {
        return items;
    }

    public Function<Purchase, Order> toModel(EntityManager manager) {
        Set<OrderItem> orderItems = items.stream().map(item -> item.toModel(manager)).collect(Collectors.toSet());
        return (purchase) -> {
            Order order = new Order(purchase, orderItems);
            Assert.isTrue(order.totalEqual(total), "O valor total enviado não corresponde ao valor total calculado do pedido.");
            return order;
        };
    }
}
