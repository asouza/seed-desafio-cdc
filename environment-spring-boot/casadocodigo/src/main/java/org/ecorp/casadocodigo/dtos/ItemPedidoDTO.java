package org.ecorp.casadocodigo.dtos;

import java.math.BigDecimal;
import org.ecorp.casadocodigo.model.ItemPedido;

public class ItemPedidoDTO {

  private LivroDTO livro;

  private Integer quantidade;

  private BigDecimal precoMomento;

  public ItemPedidoDTO(ItemPedido item) {
    this.livro = new LivroDTO(item.getLivro());
    this.quantidade = item.getQuantidade();
    this.precoMomento = item.getPrecoMomento();
  }

  public ItemPedidoDTO(LivroDTO livro, Integer quantidade, BigDecimal precoMomento) {
    this.livro = livro;
    this.quantidade = quantidade;
    this.precoMomento = precoMomento;
  }

  /**
   * @return the livro
   */
  public LivroDTO getLivro() {
    return livro;
  }

  /**
   * @return the quantidade
   */
  public Integer getQuantidade() {
    return quantidade;
  }

  /**
   * @return the precoMomento
   */
  public BigDecimal getPrecoMomento() {
    return precoMomento;
  }

  @Override
  public String toString() {
    return String.format("ItemPedidoDTO [livro=%s, quantidade=%s, precoMomento=%s]", livro,
        quantidade, precoMomento);
  }



}
