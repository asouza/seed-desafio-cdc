package org.ecorp.casadocodigo.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.ecorp.casadocodigo.model.CupomAplicado;

public class CupomAplicadoDTO {


  private String cupom;
  private LocalDate validadeMomento;
  private BigDecimal descontoMomento;

  public CupomAplicadoDTO(CupomAplicado cupomAplicado) {
    this.cupom = cupomAplicado.getCupom().getCodigo();
    this.validadeMomento = cupomAplicado.getValidadeMomento();
    this.descontoMomento = cupomAplicado.getDescontoMomento();
  }

  /**
   * @return the cupom
   */
  public String getCupom() {
    return cupom;
  }

  /**
   * @return the validadeMomento
   */
  public LocalDate getValidadeMomento() {
    return validadeMomento;
  }

  /**
   * @return the descontoMomento
   */
  public BigDecimal getDescontoMomento() {
    return descontoMomento;
  }



}
