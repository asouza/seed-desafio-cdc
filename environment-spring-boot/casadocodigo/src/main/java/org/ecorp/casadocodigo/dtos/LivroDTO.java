package org.ecorp.casadocodigo.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.ecorp.casadocodigo.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class LivroDTO {


  private Long livroID;

  @NotBlank
  @NotNull
  private String titulo;

  @NotBlank
  @NotNull
  @Size(max = 500)
  private String resumo;

  private String sumario;

  @NotNull
  @Min(20)
  private BigDecimal preco;

  @NotNull
  @Min(20)
  private Integer nuPagina;

  @NotBlank
  @NotNull
  private String isbn;

  @Future
  @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dtPublicacao;

  @NotNull
  private CategoriaDTO categoria;

  @NotNull
  private AutorDTO autor;

  public LivroDTO() {}



  public static class Builder {

    private Long livroID;
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer nuPagina;
    private String isbn;
    private LocalDate dtPublicacao;
    private CategoriaDTO categoria;
    private AutorDTO autor;

    public Builder() {}

    Builder(Long livroID, String titulo, String resumo, String sumario, BigDecimal preco,
        Integer nuPagina, String isbn, LocalDate dtPublicacao, CategoriaDTO categoria,
        AutorDTO autor) {
      this.livroID = livroID;
      this.titulo = Objects.requireNonNull(titulo);
      this.resumo = Objects.requireNonNull(resumo);
      this.sumario = sumario;
      this.preco = Objects.requireNonNull(preco);
      this.nuPagina = Objects.requireNonNull(nuPagina);
      this.isbn = Objects.requireNonNull(isbn);
      this.dtPublicacao = dtPublicacao;
      this.categoria = Objects.requireNonNull(categoria);
      this.autor = Objects.requireNonNull(autor);
    }

    public Builder livroID(Long livroID) {
      this.livroID = livroID;
      return Builder.this;
    }

    public Builder titulo(String titulo) {
      this.titulo = Objects.requireNonNull(titulo);
      return Builder.this;
    }

    public Builder resumo(String resumo) {
      this.resumo = Objects.requireNonNull(resumo);;
      return Builder.this;
    }

    public Builder sumario(String sumario) {
      this.sumario = sumario;
      return Builder.this;
    }

    public Builder preco(BigDecimal preco) {
      this.preco = Objects.requireNonNull(preco);
      return Builder.this;
    }

    public Builder nuPagina(Integer nuPagina) {
      this.nuPagina = Objects.requireNonNull(nuPagina);
      return Builder.this;
    }

    public Builder isbn(String isbn) {
      this.isbn = Objects.requireNonNull(isbn);
      return Builder.this;
    }

    public Builder dtPublicacao(LocalDate dtPublicacao) {
      this.dtPublicacao = dtPublicacao;
      return Builder.this;
    }

    public Builder categoria(CategoriaDTO categoria) {
      this.categoria = Objects.requireNonNull(categoria);
      return Builder.this;
    }

    public Builder autor(AutorDTO autor) {
      this.autor = Objects.requireNonNull(autor);
      return Builder.this;
    }

    public LivroDTO build() {

      return new LivroDTO(this);
    }
  }

  private LivroDTO(Builder builder) {
    this.livroID = builder.livroID;
    this.titulo = builder.titulo;
    this.resumo = builder.resumo;
    this.sumario = builder.sumario;
    this.preco = builder.preco;
    this.nuPagina = builder.nuPagina;
    this.isbn = builder.isbn;
    this.dtPublicacao = builder.dtPublicacao;
    this.categoria = builder.categoria;
    this.autor = builder.autor;
  }


  public LivroDTO(Livro livro) {
    this.livroID = livro.getLivroID();
    this.titulo = livro.getTitulo();
    this.resumo = livro.getResumo();
    this.sumario = livro.getSumario();
    this.preco = livro.getPreco();
    this.nuPagina = livro.getNuPagina();
    this.isbn = livro.getIsbn();
    this.dtPublicacao = livro.getDtPublicacao();
    this.categoria = new CategoriaDTO(livro.getCategoria());
    this.autor = new AutorDTO(livro.getAutor());
  }



  public Long getLivroID() {
    return livroID;
  }

  public void setLivroID(final Long livroID) {
    this.livroID = livroID;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(final String titulo) {
    this.titulo = titulo;
  }

  public String getResumo() {
    return resumo;
  }

  public void setResumo(final String resumo) {
    this.resumo = resumo;
  }

  public String getSumario() {
    return sumario;
  }

  public void setSumario(final String sumario) {
    this.sumario = sumario;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(final BigDecimal preco) {
    this.preco = preco;
  }

  public Integer getNuPagina() {
    return nuPagina;
  }

  public void setNuPagina(final Integer nuPagina) {
    this.nuPagina = nuPagina;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(final String isbn) {
    this.isbn = isbn;
  }

  public LocalDate getDtPublicacao() {
    return dtPublicacao;
  }

  public void setDtPublicacao(final LocalDate dtPublicacao) {
    this.dtPublicacao = dtPublicacao;
  }


  public CategoriaDTO getCategoria() {
    return categoria;
  }

  public void setCategoria(CategoriaDTO categoria) {
    this.categoria = categoria;
  }

  public AutorDTO getAutor() {
    return autor;
  }

  public void setAutor(AutorDTO autor) {
    this.autor = autor;
  }


  @Override
  public String toString() {
    return String.format(
        "Livro [autor=%s, categoria=%s, dtPublicacao=%s, isbn=%s, livroID=%s, nuPagina=%s, preco=%s, resumo=%s, sumario=%s, titulo=%s]",
        autor, categoria, dtPublicacao, isbn, livroID, nuPagina, preco, resumo, sumario, titulo);
  }



}
