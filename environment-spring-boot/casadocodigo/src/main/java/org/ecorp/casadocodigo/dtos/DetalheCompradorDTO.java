package org.ecorp.casadocodigo.dtos;

import java.util.Objects;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DetalheCompradorDTO {

  @NotNull
  @NotBlank
  @Email
  private String emailComprador;

  @NotNull
  @NotBlank
  private String nomeComprador;

  @NotNull
  @NotBlank
  private String sobrenomeComprador;

  @NotNull
  @NotBlank
  private String documento;

  @NotBlank
  @NotNull
  private EnderecoCompradorDTO endereco;

  @NotNull
  @NotBlank
  private String telefone;

  @NotNull
  @NotBlank
  private String cep;


  public static class Builder {

    private String emailComprador;
    private String nomeComprador;
    private String sobrenomeComprador;
    private String documento;
    private EnderecoCompradorDTO endereco;
    private String telefone;
    private String cep;

    public Builder() {}

    Builder(String emailComprador, String nomeComprador, String sobrenomeComprador,
        String documento, EnderecoCompradorDTO endereco, String telefone, String cep) {
      this.emailComprador = Objects.requireNonNull(emailComprador);
      this.nomeComprador = Objects.requireNonNull(nomeComprador);
      this.sobrenomeComprador = Objects.requireNonNull(sobrenomeComprador);
      this.documento = Objects.requireNonNull(documento);
      this.endereco = Objects.requireNonNull(endereco);
      this.telefone = Objects.requireNonNull(telefone);
      this.cep = Objects.requireNonNull(cep);
    }

    public Builder emailComprador(String emailComprador) {
      this.emailComprador = Objects.requireNonNull(emailComprador);
      return this;
    }

    public Builder nomeComprador(String nomeComprador) {
      this.nomeComprador = Objects.requireNonNull(nomeComprador);
      return Builder.this;
    }

    public Builder sobrenomeComprador(String sobrenomeComprador) {
      this.sobrenomeComprador = Objects.requireNonNull(sobrenomeComprador);
      return Builder.this;
    }

    public Builder documento(String documento) {
      this.documento = Objects.requireNonNull(documento);
      return Builder.this;
    }

    public Builder endereco(EnderecoCompradorDTO endereco) {
      this.endereco = Objects.requireNonNull(endereco);
      return Builder.this;
    }

    public Builder telefone(String telefone) {
      this.telefone = Objects.requireNonNull(telefone);
      return Builder.this;
    }

    public Builder cep(String cep) {
      this.cep = Objects.requireNonNull(cep);
      return Builder.this;
    }

    public DetalheCompradorDTO build() {

      return new DetalheCompradorDTO(this);
    }
  }

  private DetalheCompradorDTO(Builder builder) {
    this.emailComprador = builder.emailComprador;
    this.nomeComprador = builder.nomeComprador;
    this.sobrenomeComprador = builder.sobrenomeComprador;
    this.documento = builder.documento;
    this.endereco = builder.endereco;
    this.telefone = builder.telefone;
    this.cep = builder.cep;
  }

  @Override
  public String toString() {
    return String.format(
        "DetalheCompradorDTO [emailComprador=%s, nomeComprador=%s, sobrenomeComprador=%s, documento=%s, endereco=%s, telefone=%s, cep=%s]",
        emailComprador, nomeComprador, sobrenomeComprador, documento, endereco, telefone, cep);
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
   * @return the endereco
   */
  public EnderecoCompradorDTO getEndereco() {
    return endereco;
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



}
