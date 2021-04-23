package org.ecorp.casadocodigo.forms;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import org.ecorp.casadocodigo.model.Compra;
import org.ecorp.casadocodigo.model.ItemPedido;
import org.ecorp.casadocodigo.model.Pedido;
import org.ecorp.casadocodigo.repositories.LivroRespository;
import org.springframework.util.Assert;
import com.fasterxml.jackson.annotation.JsonCreator;


public class PedidoRequestForm {

  @NotNull
  @Positive
  public BigDecimal total;

  @NotEmpty
  @NotNull
  @Size(min = 1)
  @Valid
  public List<ItensPedidoFormRequest> itens;

  @JsonCreator
  public PedidoRequestForm(@NotNull @Positive BigDecimal total,
      @Valid @NotEmpty @NotNull @Size(min = 1) List<ItensPedidoFormRequest> itens) {
    this.total = Objects.requireNonNull(total);
    this.itens = Objects.requireNonNull(itens);
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
  public List<ItensPedidoFormRequest> getItens() {
    return itens;
  }

  @Override
  public String toString() {
    return String.format("PedidoRequestForm [total=%s, itens=%s]", total, itens);
  }

  public Function<Compra, Pedido> toModel(LivroRespository livroRespository) {

    Set<ItemPedido> itemPedidos =
        itens.stream().map(item -> item.toModel(livroRespository)).collect(Collectors.toSet());

    return compra -> {
      Pedido pedido = new Pedido(compra, total, itemPedidos);
      Assert.isTrue(pedido.validaPrecoTotal(total),
          "Valor calulado não corresponde ao valor enviado");
      return pedido;
    };

  }



}
