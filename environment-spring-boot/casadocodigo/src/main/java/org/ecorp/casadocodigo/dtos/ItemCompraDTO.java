package org.ecorp.casadocodigo.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import com.fasterxml.jackson.annotation.JsonCreator;

public class ItemCompraDTO {

  @NotNull
  private LivroDTO livro;

  @NotNull
  @Positive
  private Integer quantidade;

  public ItemCompraDTO() {}


  @JsonCreator
  public ItemCompraDTO(@NotNull LivroDTO livro, @NotNull @Positive Integer quantidade) {
    this();
    this.livro = livro;
    this.quantidade = quantidade;
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



}
