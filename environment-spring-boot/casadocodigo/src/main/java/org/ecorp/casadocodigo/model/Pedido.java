package org.ecorp.casadocodigo.model;

import static javax.persistence.GenerationType.SEQUENCE;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Pedido {

  @Id
  @SequenceGenerator(name = "PEDIDO_PEDIDOID_GENERATOR", sequenceName = "PEDIDO_PEDIDOID_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = SEQUENCE, generator = "PEDIDO_PEDIDOID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long pedidoID;

  @NotNull
  @Positive
  private BigDecimal total;

  @ElementCollection
  private Set<ItemPedido> itens = new HashSet<>();

  @OneToOne
  @NotNull
  @Valid
  private Compra compra;

  public Pedido(@NotNull @Valid Compra compra, @NotNull @Positive BigDecimal total,
      @Size(min = 1) Set<ItemPedido> itens) {
    this.compra = compra;
    this.total = total;
    this.itens.addAll(itens);
  }

  public boolean validaPrecoTotal(@NotNull @Positive BigDecimal total) {

    BigDecimal soma = itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO,
        (atual, proximo) -> atual.add(proximo));

    return soma.doubleValue() == total.doubleValue();
  }

  @Override
  public String toString() {
    return String.format("Pedido [total=%s, itemPedidos=%s]", total, itens);
  }

  @Deprecated
  public Pedido() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @return the pedidoID
   */
  public Long getPedidoID() {
    return pedidoID;
  }

  /**
   * @return the total
   */
  public BigDecimal getTotal() {
    return total;
  }

  /**
   * @return the itemPedidos
   */
  public Set<ItemPedido> getItens() {
    return itens;
  }

  /**
   * @return the compra
   */
  public Compra getCompra() {
    return compra;
  }



}
