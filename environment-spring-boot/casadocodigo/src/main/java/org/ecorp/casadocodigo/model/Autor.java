package org.ecorp.casadocodigo.model;

import static javax.persistence.GenerationType.SEQUENCE;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {

  @Id
  @SequenceGenerator(name = "AUTO_AUTORID_GENERATOR", sequenceName = "AUTO_AUTORID_SEQ",
      allocationSize = 1)
  @GeneratedValue(strategy = SEQUENCE, generator = "AUTO_AUTORID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long autorID;

  @Column(nullable = false)
  private String autorNome;

  @Column(nullable = false, unique = true)
  private String autorEmail;

  @Column(nullable = false, precision = 400)
  private String descricao;

  @Column(nullable = false)
  private LocalDateTime tsAlteracao;

  public Autor() {
    //
  }

  public Autor(Long autorID, String autorNome, String autorEmail, String descricao,
      LocalDateTime tsAlteracao) {
    this.autorID = autorID;
    this.autorNome = autorNome;
    this.autorEmail = autorEmail;
    this.descricao = descricao;
    this.tsAlteracao = tsAlteracao;
  }

  public Long getAutorID() {
    return autorID;
  }

  public void setAutorID(final Long autorID) {
    this.autorID = autorID;
  }

  public String getAutorNome() {
    return autorNome;
  }

  public void setAutorNome(final String autorNome) {
    this.autorNome = autorNome;
  }

  public String getAutorEmail() {
    return autorEmail;
  }

  public void setAutorEmail(final String autorEmail) {
    this.autorEmail = autorEmail;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(final String descricao) {
    this.descricao = descricao;
  }

  public LocalDateTime getTsAlteracao() {
    return tsAlteracao;
  }

  public void setTsAlteracao(final LocalDateTime tsAlteracao) {
    this.tsAlteracao = tsAlteracao;
  }

  @Override
  public String toString() {
    return String.format(
        "Autor [autorEmail=%s, autorID=%s, autorNome=%s, descricao=%s, tsAlteracao=%s]", autorEmail,
        autorID, autorNome, descricao, tsAlteracao);
  }

}
