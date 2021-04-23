package org.ecorp.casadocodigo.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.ecorp.casadocodigo.model.Livro;

public class ItemListLivroDTO {

  @NotNull
  private Long livroID;
  @NotBlank
  private String titulo;


  public ItemListLivroDTO(Livro entity) {
    this.livroID = entity.getLivroID();
    this.titulo = entity.getTitulo();
  }


  /**
   * @return the livroID
   */
  public Long getLivroID() {
    return livroID;
  }


  /**
   * @return the titulo
   */
  public String getTitulo() {
    return titulo;
  }



}
