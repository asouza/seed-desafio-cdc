package org.ecorp.casadocodigo.dtos;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.ElementCollection;
import org.ecorp.casadocodigo.model.Pedido;

public class PedidoDTO {


  private Long pedidoID;

  private BigDecimal total;

  @ElementCollection
  private Set<ItemPedidoDTO> itemPedidos = new HashSet<>();


  public PedidoDTO(Pedido pedido) {
    this.pedidoID = pedido.getPedidoID();
    this.total = pedido.getTotal();
    itemPedidos.addAll(pedido.getItens().stream().map(ItemPedidoDTO::new)
        .collect(Collectors.toSet()));
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
  public Set<ItemPedidoDTO> getItemPedidos() {
    return itemPedidos;
  }



}
