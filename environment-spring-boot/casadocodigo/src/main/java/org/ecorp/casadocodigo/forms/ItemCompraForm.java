package org.ecorp.casadocodigo.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.ecorp.casadocodigo.model.Livro;
import org.ecorp.casadocodigo.validators.ExistsID;
import com.fasterxml.jackson.annotation.JsonCreator;

public class ItemCompraForm {

  @NotNull
  @ExistsID(domainClass = Livro.class, fieldName = "livroID")
  private Long livroID;

  @NotNull
  @Positive
  private Integer quantidade;

  public ItemCompraForm() {}


  @JsonCreator
  public ItemCompraForm(
      @NotNull @ExistsID(domainClass = Livro.class, fieldName = "livroID") Long livroID,
      @NotNull @Positive Integer quantidade) {
    this();
    this.livroID = livroID;
    this.quantidade = quantidade;
  }


  /**
   * @return the livro
   */
  public Long getLivro() {
    return livroID;
  }


  /**
   * @return the quantidade
   */
  public Integer getQuantidade() {
    return quantidade;
  }


  @Override
  public String toString() {
    return String.format("ItemCompraForm [livroID=%s, quantidade=%s]", livroID, quantidade);
  }



}
