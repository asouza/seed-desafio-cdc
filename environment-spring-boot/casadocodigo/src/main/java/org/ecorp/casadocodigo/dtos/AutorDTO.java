package org.ecorp.casadocodigo.dtos;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import org.ecorp.casadocodigo.model.Autor;
import org.ecorp.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public class AutorDTO {


  private Long autorID;

  @NotEmpty
  @NotBlank
  private String autorNome;

  @NotEmpty
  @NotBlank
  @UniqueValue(domainClass = Autor.class, fieldName = "autor_email")
  private String autorEmail;

  @NotEmpty
  @NotBlank
  @Size(max = 400)
  private String descricao;

  @PastOrPresent
  private LocalDateTime tsAlteracao;



  public AutorDTO(final Autor entity) {
    this.autorID = entity.getAutorID();
    this.autorNome = entity.getAutorNome();
    this.autorEmail = entity.getAutorEmail();
    this.descricao = entity.getDescricao();
    this.tsAlteracao = entity.getTsAlteracao();
  }

  public Autor map() {
    return new Autor(this.autorID, this.autorNome, this.autorEmail, this.descricao,
        this.tsAlteracao);
  }

  public AutorDTO() {
    this.tsAlteracao = LocalDateTime.now();
  }

  @JsonCreator
  public AutorDTO(Long autorID, @NotEmpty @NotBlank String autorNome,
      @NotEmpty @NotBlank String autorEmail,
      @NotEmpty @NotBlank @Size(max = 400) String descricao) {
    this();
    this.autorID = autorID;
    this.autorNome = autorNome;
    this.autorEmail = autorEmail;
    this.descricao = descricao;
  }

  public Long getAutorID() {
    return autorID;
  }

  /**
   * @return the autorNome
   */
  public String getAutorNome() {
    return autorNome;
  }

  /**
   * @return the autorEmail
   */
  public String getAutorEmail() {
    return autorEmail;
  }

  /**
   * @return the descricao
   */
  public String getDescricao() {
    return descricao;
  }

  /**
   * @return the tsAlteracao
   */
  public LocalDateTime getTsAlteracao() {
    return tsAlteracao;
  }



}
