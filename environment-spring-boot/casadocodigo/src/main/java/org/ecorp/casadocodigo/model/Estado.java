package org.ecorp.casadocodigo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

  @Id
  @SequenceGenerator(name = "ESTADO_ESTADOID_GENERATOR", sequenceName = "ESTADO_ESTADOID_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTADO_ESTADOID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long estadoID;

  @NotNull
  @Column(nullable = false, unique = true)
  private String nomeEstado;


  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "paisID", nullable = false)
  private Pais pais;

  @Deprecated
  public Estado() {}

  public Estado(@NotNull String nomeEstado, @NotNull Pais pais) {
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
   * @param estadoID the estadoID to set
   */
  public void setEstadoID(Long estadoID) {
    this.estadoID = estadoID;
  }

  /**
   * @return the nomeEstado
   */
  public String getNomeEstado() {
    return nomeEstado;
  }

  /**
   * @param nomeEstado the nomeEstado to set
   */
  public void setNomeEstado(String nomeEstado) {
    this.nomeEstado = nomeEstado;
  }

  /**
   * @return the pais
   */
  public Pais getPais() {
    return pais;
  }

  /**
   * @param pais the pais to set
   */
  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public boolean pertence(Pais foundPais) {

    return this.pais.equals(pais);
  }

  @Override
  public String toString() {
    return String.format("Estado [estadoID=%s, nomeEstado=%s, pais=%s]", estadoID, nomeEstado,
        pais);
  }



}
