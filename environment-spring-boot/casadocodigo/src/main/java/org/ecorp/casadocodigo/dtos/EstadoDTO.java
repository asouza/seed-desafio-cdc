package org.ecorp.casadocodigo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Estado;
import org.ecorp.casadocodigo.model.Pais;
import org.ecorp.casadocodigo.validators.ExistsID;
import org.ecorp.casadocodigo.validators.UniqueValue;

public class EstadoDTO {



  private Long estadoID;

  @NotNull
  @NotBlank
  @UniqueValue(domainClass = Estado.class, fieldName = "nomeEstado")
  private String nomeEstado;

  @ExistsID(domainClass = Pais.class, fieldName = "paisID")
  @NotNull
  private PaisDTO pais;


  public EstadoDTO(Estado estado) {
    this.estadoID = estado.getEstadoID();
    this.nomeEstado = estado.getNomeEstado();
    this.pais = new PaisDTO(estado.getPais());
  }


  public EstadoDTO(Long estadoID,
      @NotNull @NotBlank @UniqueValue(domainClass = Estado.class,
          fieldName = "nomeEstado") String nomeEstado,
      @ExistsID(domainClass = Pais.class, fieldName = "paisID") @NotNull PaisDTO pais) {
    this.estadoID = estadoID;
    this.nomeEstado = nomeEstado;
    this.pais = pais;
  }


  /**
   * @return the estadoID
   */
  public Long getEstadoID() {
    return estadoID;
  }


  /**
   * @return the nomeEstado
   */
  public String getNomeEstado() {
    return nomeEstado;
  }


  /**
   * @return the pais
   */
  public PaisDTO getPais() {
    return pais;
  }



}
