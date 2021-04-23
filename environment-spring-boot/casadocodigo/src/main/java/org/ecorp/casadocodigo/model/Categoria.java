package org.ecorp.casadocodigo.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Categoria {


  @Id
  @SequenceGenerator(name = "CATEGORIA_CATEGORIAID_GENERATOR",
      sequenceName = "CATEGORIA_CATEGORIAID_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_CATEGORIAID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long categoriaID;

  @Column(nullable = false, unique = true)
  private String categoriaNome;

  @Column(nullable = false)
  private LocalDateTime instanteAlteracao;

  public Categoria() { //
  }


  public Categoria(Long categoriaID, String categoriaNome, LocalDateTime instanteAlteracao) {
    this.categoriaID = categoriaID;
    this.categoriaNome = categoriaNome;
    this.instanteAlteracao = instanteAlteracao;
  }


  /**
   * @return the categoriaID
   */
  public Long getCategoriaID() {
    return categoriaID;
  }

  /**
   * @param categoriaID the categoriaID to set
   */
  public void setCategoriaID(Long categoriaID) {
    this.categoriaID = categoriaID;
  }

  /**
   * @return the categoriaNome
   */
  public String getCategoriaNome() {
    return categoriaNome;
  }

  /**
   * @param categoriaNome the categoriaNome to set
   */
  public void setCategoriaNome(String categoriaNome) {
    this.categoriaNome = categoriaNome;
  }

  /**
   * @return the instanteAlteracao
   */
  public LocalDateTime getInstanteAlteracao() {
    return instanteAlteracao;
  }

  /**
   * @param instanteAlteracao the instanteAlteracao to set
   */
  public void setInstanteAlteracao(LocalDateTime instanteAlteracao) {
    this.instanteAlteracao = instanteAlteracao;
  }



}
