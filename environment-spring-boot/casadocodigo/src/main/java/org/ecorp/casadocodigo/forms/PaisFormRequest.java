package org.ecorp.casadocodigo.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Pais;
import org.ecorp.casadocodigo.validators.UniqueValue;

public class PaisFormRequest {

  @NotNull
  @NotBlank
  @UniqueValue(domainClass = Pais.class, fieldName = "nomePais")
  private String nomePais;

  public Pais toModel() {
    return new Pais(nomePais);
  }

  @Override
  public String toString() {
    return String.format("PaisForm [nomePais=%s]", nomePais);
  }

  public PaisFormRequest() {
    // Auto-generated constructor stub
  }

  public PaisFormRequest(@NotNull @NotBlank @UniqueValue(domainClass = Pais.class,
      fieldName = "nomePais") String nomePais) {
    this.nomePais = nomePais;
  }

  /**
   * @return the nomePais
   */
  public String getNomePais() {
    return nomePais;
  }

  /**
   * @param nomePais the nomePais to set
   */
  public void setNomePais(String nomePais) {
    this.nomePais = nomePais;
  }



}
