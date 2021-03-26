package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.ExistsId;
import br.com.armando.decasadocodigo.api.validator.UniqueValue;
import br.com.armando.decasadocodigo.domain.model.Author;
import br.com.armando.decasadocodigo.domain.model.Book;
import br.com.armando.decasadocodigo.domain.model.Category;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BookRequest {

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @NotBlank
    @Size(max = 500)
    private String summary;

    @NotBlank
    private String index;

    @NotNull
    @Min(value = 20)
    private BigDecimal price;

    @NotNull
    @Min(value = 100)
    private Integer pages;

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;

    @NotNull
    @Future
    private LocalDate publishDate;

    @NotNull
    @ExistsId(domainClass = Category.class, fieldName = "id")
    private Long categoryId;

    @NotNull
    @ExistsId(domainClass = Author.class, fieldName = "id")
    private Long authorId;

    public BookRequest(
            @NotBlank @UniqueValue(domainClass = Book.class, fieldName = "title") String title,
            @NotBlank @Size(max = 500) String summary,
            @NotBlank String index,
            @NotNull @Min(value = 20) BigDecimal price,
            @NotNull @Min(value = 100) Integer pages,
            @NotBlank @UniqueValue(domainClass = Book.class, fieldName = "isbn") String isbn,
            @NotNull @Future LocalDate publishDate,
            @ExistsId(domainClass = Category.class, fieldName = "id") @NotNull Long categoryId,
            @ExistsId(domainClass = Author.class, fieldName = "id") @NotNull Long authorId
    ) {
        this.title = title;
        this.summary = summary;
        this.index = index;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public Book toModel(EntityManager manager) {
        Category category = manager.find(Category.class, this.categoryId);
        Author author = manager.find(Author.class, this.authorId);

        Assert.state(category!=null, "Categoria não pode ser nula");
        Assert.state(author!=null, "Autor não pode ser nulo");

        Book book = new Book(
                this.title,
                this.summary,
                this.index,
                this.price,
                this.pages,
                this.isbn,
                this.publishDate,
                category,
                author
        );
        return book;
    }
}
