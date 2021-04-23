package org.ecorp.casadocodigo.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class ItemPedido {
  

  @ManyToOne
  @JoinColumn(name = "livroID", nullable = false)
  private Livro livro;

  @NotNull
  @Positive
  @Column(nullable = false)
  private Integer quantidade;

  @Positive
  @Column(nullable = false)
  private BigDecimal precoMomento;

  public ItemPedido(Livro livro, @NotNull @Positive Integer quantidade) {
    this.livro = livro;
    this.quantidade = quantidade;
    this.precoMomento = livro.getPreco();
  }

  @Deprecated
  public ItemPedido() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @return the livro
   */
  public Livro getLivro() {
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

  public BigDecimal total() {
    return precoMomento.multiply(new BigDecimal(quantidade));
  }

  @Override
  public String toString() {
    return String.format("ItemPedido [livro=%s, quantidade=%s, precoMomento=%s]", livro, quantidade,
        precoMomento);
  }



  @Override
  public int hashCode() {
    return Objects.hash(livro);
  }



  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ItemPedido other = (ItemPedido) obj;
    return Objects.equals(livro, other.livro);
  }



}
