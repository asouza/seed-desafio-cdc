package org.ecorp.casadocodigo.forms;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import org.ecorp.casadocodigo.model.Categoria;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class CategoriaFormRequest {

  @NotBlank
  @UniqueValue(domainClass = Categoria.class, fieldName = "categoriaNome")
  private String categoriaNome;

  @JsonCreator
  public CategoriaFormRequest(@NotBlank @UniqueValue(domainClass = Categoria.class,
      fieldName = "nome") String categoriaNome) {
    this.categoriaNome = categoriaNome;
  }

  public Categoria map() {
    return new Categoria(null, this.categoriaNome, LocalDateTime.now());
  }

  /**
   * @return the categoriaNome
   */
  public String getCategoriaNome() {
    return categoriaNome;
  }

  @Override
  public String toString() {
    return String.format("CategoriaFormRequest [categoriaNome=%s]", categoriaNome);
  }



}
