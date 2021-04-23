package org.ecorp.casadocodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Cupom {

  @Id
  @Column(nullable = false, unique = true)
  private String codigo;

  @Column(nullable = false)
  private BigDecimal percentualDesconto;

  @Column(nullable = false)
  private LocalDate validade;



  public Cupom(String codigo, @Size(max = 100, min = 0) BigDecimal percentualDesconto,
      LocalDate validade) {
    this.codigo = codigo;
    this.percentualDesconto = percentualDesconto;
    this.validade = validade;
  }


  @Deprecated
  public Cupom() {
    // TODO Auto-generated constructor stub
  }


  /**
   * @return the codigo
   */
  public String getCodigo() {
    return codigo;
  }


  /**
   * @param codigo the codigo to set
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }


  /**
   * @return the validade
   */
  public LocalDate getValidade() {
    return validade;
  }


  /**
   * @param validade the validade to set
   */
  public void setValidade(LocalDate validade) {
    this.validade = validade;
  }


  /**
   * @return the desconto
   */
  public BigDecimal getDesconto() {
    return percentualDesconto;
  }


  /**
   * @param desconto the desconto to set
   */
  public void setDesconto(BigDecimal desconto) {
    this.percentualDesconto = desconto;
  }


  @Override
  public String toString() {
    return String.format("Cupom [codigo=%s, percentualDesconto=%s, validade=%s]", codigo,
        percentualDesconto, validade);
  }

}
