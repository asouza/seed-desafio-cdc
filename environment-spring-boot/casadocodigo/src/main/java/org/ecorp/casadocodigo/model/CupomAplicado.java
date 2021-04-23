package org.ecorp.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CupomAplicado {

  @ManyToOne
  private Cupom cupom;
  @Column(updatable = false)
  private LocalDate validadeMomento;
  @Column(updatable = false)
  private BigDecimal descontoMomento;

  public CupomAplicado(Cupom cupom) {
    this.cupom = cupom;
    this.validadeMomento = cupom.getValidade();
    this.descontoMomento = cupom.getDesconto();
  }


  public CupomAplicado() {}

  /**
   * @return the cupom
   */
  public Cupom getCupom() {
    return cupom;
  }

  /**
   * @param cupom the cupom to set
   */
  public void setCupom(Cupom cupom) {
    this.cupom = cupom;
  }

  /**
   * @return the validadeMomento
   */
  public LocalDate getValidadeMomento() {
    return validadeMomento;
  }

  /**
   * @param validadeMomento the validadeMomento to set
   */
  public void setValidadeMomento(LocalDate validadeMomento) {
    this.validadeMomento = validadeMomento;
  }

  /**
   * @return the descontoMomento
   */
  public BigDecimal getDescontoMomento() {
    return descontoMomento;
  }

  /**
   * @param descontoMomento the descontoMomento to set
   */
  public void setDescontoMomento(BigDecimal descontoMomento) {
    this.descontoMomento = descontoMomento;
  }

  @Override
  public String toString() {
    return String.format("CupomAplicado [cupom=%s, validadeMomento=%s, descontoMomento=%s]", cupom,
        validadeMomento, descontoMomento);
  }



}
