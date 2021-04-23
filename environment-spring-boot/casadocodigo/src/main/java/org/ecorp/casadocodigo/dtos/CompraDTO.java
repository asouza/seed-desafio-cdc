package org.ecorp.casadocodigo.dtos;

import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Compra;

public class CompraDTO {

  private Long compraID;

  @NotBlank
  @Email
  private String emailComprador;

  @NotBlank
  private String nomeComprador;

  @NotBlank
  private String sobrenomeComprador;

  @NotBlank
  private String documento;

  @NotBlank
  public String rua;

  @NotBlank
  public String complemento;

  @NotBlank
  public String cidade;

  @NotNull
  public PaisDTO pais;

  public EstadoDTO estado;

  @NotNull
  private String telefone;

  @NotBlank
  private String cep;

  private CupomAplicadoDTO cupom;

  @OneToOne(mappedBy = "compra", cascade = PERSIST)
  private PedidoDTO pedido;


  public CompraDTO(Compra compra) {

    this.compraID = compra.getCompraID();
    this.emailComprador = compra.getEmailComprador();
    this.nomeComprador = compra.getNomeComprador();
    this.sobrenomeComprador = compra.getSobrenomeComprador();
    this.documento = compra.getDocumento();
    this.rua = compra.getRua();
    this.complemento = compra.getComplemento();
    this.cidade = compra.getCidade();
    this.pais = new PaisDTO(compra.getPais());
    this.estado = new EstadoDTO(compra.getEstado());
    this.telefone = compra.getTelefone();
    this.cep = compra.getCep();
    this.pedido = new PedidoDTO(compra.getPedido());
    this.cupom = new CupomAplicadoDTO(compra.getCupomAplicado());
  }


  /**
   * @return the compraID
   */
  public Long getCompraID() {
    return compraID;
  }


  /**
   * @return the emailComprador
   */
  public String getEmailComprador() {
    return emailComprador;
  }


  /**
   * @return the nomeComprador
   */
  public String getNomeComprador() {
    return nomeComprador;
  }


  /**
   * @return the sobrenomeComprador
   */
  public String getSobrenomeComprador() {
    return sobrenomeComprador;
  }


  /**
   * @return the documento
   */
  public String getDocumento() {
    return documento;
  }


  /**
   * @return the rua
   */
  public String getRua() {
    return rua;
  }


  /**
   * @return the complemento
   */
  public String getComplemento() {
    return complemento;
  }


  /**
   * @return the cidade
   */
  public String getCidade() {
    return cidade;
  }


  /**
   * @return the pais
   */
  public PaisDTO getPais() {
    return pais;
  }


  /**
   * @return the estado
   */
  public EstadoDTO getEstado() {
    return estado;
  }


  /**
   * @return the telefone
   */
  public String getTelefone() {
    return telefone;
  }


  /**
   * @return the cep
   */
  public String getCep() {
    return cep;
  }


  /**
   * @return the pedido
   */
  public PedidoDTO getPedido() {
    return pedido;
  }

  public CupomAplicadoDTO getCupom() {
    return cupom;
  }

  @Override
  public String toString() {
    return String.format(
        "CompraDTO [compraID=%s, emailComprador=%s, nomeComprador=%s, sobrenomeComprador=%s, documento=%s, rua=%s, complemento=%s, cidade=%s, pais=%s, estado=%s, telefone=%s, cep=%s, pedido=%s]",
        compraID, emailComprador, nomeComprador, sobrenomeComprador, documento, rua, complemento,
        cidade, pais, estado, telefone, cep, pedido);
  }



}
