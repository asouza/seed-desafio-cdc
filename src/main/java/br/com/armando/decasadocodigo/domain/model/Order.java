package br.com.armando.decasadocodigo.domain.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Purchase purchase;

    @ElementCollection
    private Set<OrderItem> items = new HashSet<>();

    @Deprecated
    public Order() {
    }

    public Order(Purchase purchase, Set<OrderItem> items) {
        Assert.isTrue(!items.isEmpty(), "Todo pedido deve ter pelo menos 1 item.");
        this.purchase = purchase;
        this.items.addAll(items);
    }

    public Long getId() {
        return id;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public boolean totalEqual(BigDecimal total) {
        return calculateTotal().doubleValue() == total.doubleValue();
    }

    public BigDecimal calculateTotal() {
        return items.stream().map(OrderItem::total).reduce(BigDecimal.ZERO, (current, next) -> current.add(next));
    }

}
