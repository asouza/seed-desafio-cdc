package org.ecorp.casadocodigo.forms;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.ecorp.casadocodigo.model.Cupom;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovoCupomRequest {


  @NotBlank
  @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
  private String codigo;

  @Positive
  @NotNull
  private BigDecimal percentualDesconto;

  @Future
  @NotNull
  @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
  private LocalDate validade;

  @JsonCreator
  public NovoCupomRequest(
      @NotBlank @UniqueValue(domainClass = Cupom.class, fieldName = "codigo") String codigo,
      @Positive @NotNull BigDecimal percentualDesconto, @Future @NotNull LocalDate validade) {
    this.codigo = codigo;
    this.percentualDesconto = percentualDesconto;
    this.validade = validade;
  }

  public Cupom toModel() {
    return new Cupom(this.codigo, this.percentualDesconto, this.validade);
  }



}
