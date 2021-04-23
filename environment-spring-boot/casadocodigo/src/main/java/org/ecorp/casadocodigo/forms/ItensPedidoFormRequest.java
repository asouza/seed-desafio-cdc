package org.ecorp.casadocodigo.forms;

import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.ecorp.casadocodigo.model.ItemPedido;
import org.ecorp.casadocodigo.model.Livro;
import org.ecorp.casadocodigo.repositories.LivroRespository;
import org.ecorp.casadocodigo.validators.ExistsID;
import com.fasterxml.jackson.annotation.JsonCreator;

public class ItensPedidoFormRequest {

  @NotNull
  @ExistsID(domainClass = Livro.class, fieldName = "livroID")
  private Long livroID;

  @NotNull
  @Positive
  private Integer quantidade;

  @JsonCreator
  public ItensPedidoFormRequest(
      @Valid @NotNull @ExistsID(domainClass = Livro.class, fieldName = "livroID") Long livroID,
      @Valid @NotNull @Positive Integer quantidade) {
    this.livroID = Objects.requireNonNull(livroID);
    this.quantidade = Objects.requireNonNull(quantidade);
  }

  public Long getLivroID() {
    return livroID;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  @Override
  public String toString() {
    return String.format("ItensPedidoFormRequest [livroID=%s, quantidade=%s]", livroID, quantidade);
  }

  public ItemPedido toModel(LivroRespository livroRespository) {
    Optional<Livro> livro = livroRespository.findById(livroID);
    ItemPedido item = new ItemPedido(livro.get(), quantidade);
    return item;
  }
}
