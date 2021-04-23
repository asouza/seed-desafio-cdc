package org.ecorp.casadocodigo.dtos;

import java.util.Objects;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EnderecoCompradorDTO {
  @NotBlank
  @NotNull
  public @NotNull @NotBlank String rua;
  @NotBlank
  @NotNull
  public @NotNull @NotBlank String complemento;
  @NotBlank
  @NotNull
  public @NotNull @NotBlank String cidade;
  @NotBlank
  @NotNull
  public @NotNull @NotBlank PaisDTO paisID;
  public EstadoDTO estadoID;

  public EnderecoCompradorDTO() {}

  public EnderecoCompradorDTO(Builder builder) {
    this.rua = Objects.requireNonNull(builder.rua);
    this.complemento = Objects.requireNonNull(builder.complemento);
    this.cidade = Objects.requireNonNull(builder.cidade);
    this.paisID = Objects.requireNonNull(builder.paisID);
    this.estadoID = builder.estadoID;
  }

  public static class Builder {

    private String rua;
    private String complemento;
    private String cidade;
    private PaisDTO paisID;
    private EstadoDTO estadoID;

    public Builder() {}

    Builder(String rua, String complemento, String cidade, PaisDTO paisID, EstadoDTO estadoID) {
      this.rua = Objects.requireNonNull(rua);
      this.complemento = Objects.requireNonNull(complemento);
      this.cidade = Objects.requireNonNull(cidade);
      this.paisID = Objects.requireNonNull(paisID);
      this.estadoID = estadoID;
    }

    /**
     * @param rua the rua to set
     */
    public Builder rua(String rua) {
      this.rua = Objects.requireNonNull(rua);
      return this;
    }

    /**
     * @param complemento the complemento to set
     */
    public Builder complemento(String complemento) {
      this.complemento = Objects.requireNonNull(complemento);
      return this;
    }

    /**
     * @param cidade the cidade to set
     */
    public Builder cidade(String cidade) {
      this.cidade = Objects.requireNonNull(cidade);
      return this;
    }

    /**
     * @param paisID the paisID to set
     */
    public Builder paisID(PaisDTO paisID) {
      this.paisID = Objects.requireNonNull(paisID);;
      return this;
    }

    /**
     * @param estadoID the estadoID to set
     */
    public Builder estadoID(EstadoDTO estadoID) {
      this.estadoID = estadoID;
      return this;
    }

    public EnderecoCompradorDTO build() {
      return new EnderecoCompradorDTO(this);
    }
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
   * @return the paisID
   */
  public PaisDTO getPaisID() {
    return paisID;
  }

  /**
   * @return the estadoID
   */
  public EstadoDTO getEstadoID() {
    return estadoID;
  }

  @Override
  public String toString() {
    return String.format(
        "EnderocoCompradorDTO [rua=%s, complemento=%s, cidade=%s, paisID=%s, estadoID=%s]", rua,
        complemento, cidade, paisID, estadoID);
  }

}
