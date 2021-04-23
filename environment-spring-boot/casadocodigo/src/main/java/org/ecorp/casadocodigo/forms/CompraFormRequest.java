package org.ecorp.casadocodigo.forms;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Compra;
import org.ecorp.casadocodigo.model.Cupom;
import org.ecorp.casadocodigo.model.Estado;
import org.ecorp.casadocodigo.model.Pais;
import org.ecorp.casadocodigo.model.Pedido;
import org.ecorp.casadocodigo.repositories.CupomRepository;
import org.ecorp.casadocodigo.repositories.EstadoRepository;
import org.ecorp.casadocodigo.repositories.LivroRespository;
import org.ecorp.casadocodigo.repositories.PaisRepository;
import org.ecorp.casadocodigo.validators.CupomValido;
import org.ecorp.casadocodigo.validators.ExistsID;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CompraFormRequest {


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
  @ExistsID(domainClass = Pais.class, fieldName = "paisID")
  public Long paisID;

  @ExistsID(domainClass = Estado.class, fieldName = "estadoID")
  public Long estadoID;

  @NotNull
  private String telefone;

  @NotBlank
  private String cep;

  @ExistsID(domainClass = Cupom.class, fieldName = "codigo")
  @CupomValido
  private String cupom;

  @NotNull
  @Valid
  private PedidoRequestForm pedido;


  @JsonCreator
  public CompraFormRequest(@NotBlank @Email String emailComprador, @NotBlank String nomeComprador,
      @NotBlank String sobrenomeComprador, @NotBlank String documento, @NotBlank String rua,
      @NotBlank String complemento, @NotBlank String cidade,
      @NotNull @ExistsID(domainClass = Pais.class, fieldName = "paisID") Long paisID,
      @ExistsID(domainClass = Estado.class, fieldName = "estadoID") Long estadoID,
      @NotNull String telefone, @NotBlank String cep, @Valid @NotNull PedidoRequestForm pedido,  @ExistsID(domainClass = Cupom.class, fieldName = "codigo")
      @CupomValido
      String cupom) {

    this.emailComprador = Objects.requireNonNull(emailComprador);
    this.nomeComprador = Objects.requireNonNull(nomeComprador);
    this.sobrenomeComprador = Objects.requireNonNull(sobrenomeComprador);
    this.documento = Objects.requireNonNull(documento);
    this.rua = Objects.requireNonNull(rua);
    this.complemento = Objects.requireNonNull(complemento);
    this.cidade = Objects.requireNonNull(cidade);
    this.paisID = Objects.requireNonNull(paisID);
    this.estadoID = estadoID;
    this.telefone = Objects.requireNonNull(telefone);
    this.cep = Objects.requireNonNull(cep);
    this.pedido = Objects.requireNonNull(pedido);
    this.cupom = cupom;
  }


  public boolean documentoValido() {
    Assert.hasLength(documento,
        "voce não deveria validar o documento se ele não tiver sido preenchido");

    CPFValidator cpfValidator = new CPFValidator();
    cpfValidator.initialize(null);

    CNPJValidator cnpjValidator = new CNPJValidator();
    cnpjValidator.initialize(null);

    return cpfValidator.isValid(documento, null) || cnpjValidator.isValid(documento, null);

  }



  public String getEmailComprador() {
    return emailComprador;
  }


  public String getNomeComprador() {
    return nomeComprador;
  }


  public String getSobrenomeComprador() {
    return sobrenomeComprador;
  }


  public String getDocumento() {
    return documento;
  }


  public String getRua() {
    return rua;
  }


  public String getComplemento() {
    return complemento;
  }


  public String getCidade() {
    return cidade;
  }


  public Long getPaisID() {
    return paisID;
  }


  public Long getEstadoID() {
    return estadoID;
  }

  public String getCupom() {
    return cupom;
  }


  public String getTelefone() {
    return telefone;
  }


  public String getCep() {
    return cep;
  }

  public PedidoRequestForm getPedido() {
    return pedido;
  }


  @Override
  public String toString() {
    return String.format(
        "CompraFormRequest [emailComprador=%s, nomeComprador=%s, sobrenomeComprador=%s, documento=%s, rua=%s, complemento=%s, cidade=%s, paisID=%s, estadoID=%s, telefone=%s, cep=%s, pedido=%s]",
        emailComprador, nomeComprador, sobrenomeComprador, documento, rua, complemento, cidade,
        paisID, estadoID, telefone, cep, pedido);
  }

  /**
   * Realiza o mapeamento de CompraFormRequest para uma entidade Compra
   * 
   * @param reposotyPais
   * @param reposotyEstado
   * @param livroRespository
   * @param cupomRepository
   * @return
   */

  public Compra toModel(PaisRepository reposotyPais, EstadoRepository reposotyEstado,
      LivroRespository livroRespository, CupomRepository cupomRepository) {

    Optional<Pais> pais = reposotyPais.findById(paisID);
    Cupom cupom = cupomRepository.findByCodigo(this.cupom);

    Function<Compra, Pedido> funcaoConstrutorPedido = pedido.toModel(livroRespository);


    Compra compra = new Compra(emailComprador, nomeComprador, sobrenomeComprador, documento, rua,
        complemento, cidade, pais.get(), telefone, cep, funcaoConstrutorPedido, cupom);
    if (estadoID != null) {
      Optional<Estado> estado = reposotyEstado.findById(estadoID);
      compra.setEstado(estado.get());
    }


    return compra;
  }


}
