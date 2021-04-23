package org.ecorp.casadocodigo.model;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.GenerationType.SEQUENCE;
import java.util.Objects;
import java.util.function.Function;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.util.Assert;

@Entity
public class Compra {

  @Id
  @SequenceGenerator(name = "COMPRA_COMPRAID_GENERATOR", sequenceName = "COMPRA_COMPRAID_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = SEQUENCE, generator = "COMPRA_COMPRAID_GENERATOR")
  @Column(unique = true, nullable = false)          
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
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "paisid", nullable = false, foreignKey = @ForeignKey(name = "paisid_fk"))
  public Pais pais;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "estadoid", foreignKey = @ForeignKey(name = "estadoid_fk"))
  public Estado estado;

  @NotNull
  private String telefone;

  @NotBlank
  private String cep;

  @OneToOne(mappedBy = "compra", cascade = PERSIST)
  private Pedido pedido;
  
  @Column(updatable = false)
  private CupomAplicado cupomAplicado;

  public Compra(@NotBlank @Email String emailComprador, @NotBlank String nomeComprador,
      @NotBlank String sobrenomeComprador, @NotBlank String documento, @NotBlank String rua,
      @NotBlank String complemento, @NotBlank String cidade, Pais pais, @NotNull String telefone,
      @NotBlank String cep, Function<Compra, Pedido> funcaoConstrutorPedido, Cupom cupom) {

    this.emailComprador = Objects.requireNonNull(emailComprador);
    this.nomeComprador = Objects.requireNonNull(nomeComprador);
    this.sobrenomeComprador = Objects.requireNonNull(sobrenomeComprador);
    this.documento = Objects.requireNonNull(documento);
    this.rua = Objects.requireNonNull(rua);
    this.complemento = Objects.requireNonNull(complemento);
    this.cidade = Objects.requireNonNull(cidade);
    this.pais = Objects.requireNonNull(pais);
    this.telefone = Objects.requireNonNull(telefone);
    this.cep = Objects.requireNonNull(cep);
    this.cupomAplicado = new CupomAplicado(cupom);
    this.pedido = funcaoConstrutorPedido.apply(this);
  }



  @Override
  public String toString() {
    return String.format(
        "Compra [compraID=%s, emailComprador=%s, nomeComprador=%s, sobrenomeComprador=%s, documento=%s, rua=%s, complemento=%s, cidade=%s, pais=%s, estado=%s, telefone=%s, cep=%s, pedido=%s]",
        compraID, emailComprador, nomeComprador, sobrenomeComprador, documento, rua, complemento,
        cidade, pais, estado, telefone, cep, pedido);
  }



  public void setEstado(@NotNull @Valid Estado estado) {
    Assert.notNull(pais, "Deve ter um pais assoaciado");
    Assert.isTrue(estado.pertence(pais), "Este Estado não é do pais Associado");
    this.estado = estado;
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
  public Pais getPais() {
    return pais;
  }



  /**
   * @return the estado
   */
  public Estado getEstado() {
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
  public Pedido getPedido() {
    return pedido;
  }
  
  
  public CupomAplicado getCupomAplicado() {
    return cupomAplicado;
  }
  



}
