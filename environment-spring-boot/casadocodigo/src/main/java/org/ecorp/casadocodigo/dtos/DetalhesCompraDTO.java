package org.ecorp.casadocodigo.dtos;

import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import com.fasterxml.jackson.annotation.JsonCreator;

public class DetalhesCompraDTO {

  @NotNull
  @PositiveOrZero
  private BigDecimal total;

  @NotNull
  private List<ItemCompraDTO> itens;

  public DetalhesCompraDTO() {}

  @JsonCreator
  public DetalhesCompraDTO(@NotNull @PositiveOrZero BigDecimal total,
      @NotNull List<ItemCompraDTO> itens) {
    this.total = total;
    this.itens = itens;
  }



  /**
   * @return the total
   */
  public BigDecimal getTotal() {
    return total;
  }

  /**
   * @return the itens
   */
  public List<ItemCompraDTO> getItens() {
    return itens;
  }


}
