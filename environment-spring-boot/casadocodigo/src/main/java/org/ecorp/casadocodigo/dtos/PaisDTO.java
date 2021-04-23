package org.ecorp.casadocodigo.dtos;

import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Pais;
import org.ecorp.casadocodigo.validators.UniqueValue;

public class PaisDTO {


  private Long paisID;

  @NotNull
  @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
  private final String nomePais;

  public PaisDTO(Pais pais) {
    this.nomePais = pais.getNomePais();
    this.paisID = pais.getPaisID();
  }



  public PaisDTO(
      @NotNull @UniqueValue(domainClass = Pais.class, fieldName = "nomePais") String nomePais) {
    this.nomePais = nomePais;
  }



  /**
   * @return the paisID
   */
  public Long getPaisID() {
    return paisID;
  }


  /**
   * @return the nomePais
   */
  public String getNomePais() {
    return nomePais;
  }

  public Pais map() {
    return new Pais(this.paisID, this.nomePais);
  }



}
