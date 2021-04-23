package org.ecorp.casadocodigo.dtos;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import org.ecorp.casadocodigo.model.Categoria;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaDTO {


  private Long categoriaID;

  @NotNull
  @NotBlank
  @UniqueValue(domainClass = Categoria.class, fieldName = "categoriaNome")
  private String categoriaNome;

  @PastOrPresent
  private LocalDateTime instanteAlteracao;

  public CategoriaDTO() {
    this.instanteAlteracao = LocalDateTime.now();
  }

  @JsonCreator
  public CategoriaDTO(Long categoriaID,
      @NotNull @NotBlank @UniqueValue(domainClass = Categoria.class,
          fieldName = "nome") String categoriaNome) {
    this();
    this.categoriaID = categoriaID;
    this.categoriaNome = categoriaNome;
  }

  public CategoriaDTO(Categoria categoria) {
    this.categoriaID = categoria.getCategoriaID();
    this.categoriaNome = categoria.getCategoriaNome();
    this.instanteAlteracao = categoria.getInstanteAlteracao();
  }

  public Categoria map() {
    return new Categoria(this.categoriaID, this.categoriaNome, this.instanteAlteracao);
  }

  /**
   * @return the categoriaID
   */
  public Long getCategoriaID() {
    return categoriaID;
  }

  /**
   * @return the categoriaNome
   */
  public String getCategoriaNome() {
    return categoriaNome;
  }

  /**
   * @return the instanteAlteracao
   */
  public LocalDateTime getInstanteAlteracao() {
    return instanteAlteracao;
  }
  
  



}
