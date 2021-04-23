package org.ecorp.casadocodigo.forms;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Estado;
import org.ecorp.casadocodigo.model.Pais;
import org.ecorp.casadocodigo.validators.ExistsID;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class EstadoFormRequest {

  @NotNull
  @NotBlank
  @UniqueValue(domainClass = Estado.class, fieldName = "nomeEstado")
  private String nomeEstado;

  @ExistsID(domainClass = Pais.class, fieldName = "paisID")
  @NotNull
  private Long paisID;

  @JsonCreator
  public EstadoFormRequest(
      @NotNull @NotBlank @UniqueValue(domainClass = Estado.class,
          fieldName = "nomeEstado") String nomeEstado,
      @ExistsID(domainClass = Pais.class, fieldName = "paisID") @NotNull Long paisID) {
    this.nomeEstado = nomeEstado;
    this.paisID = paisID;
  }

  /**
   * @return the nomeEstado
   */
  public String getNomeEstado() {
    return nomeEstado;
  }

  /**
   * @return the paisID
   */
  public Long getPaisID() {
    return paisID;
  }

  public Estado toModel(EntityManager manager) {
    Pais pais = manager.find(Pais.class, this.paisID);
    return new Estado(this.nomeEstado, pais);
  }



}
