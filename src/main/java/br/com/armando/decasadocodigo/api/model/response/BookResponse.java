package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.Book;

import java.math.BigDecimal;
import java.time.LocalDate;

public class BookResponse {

    private Long id;
    private String title;
    private String summary;
    private String index;
    private BigDecimal price;
    private Integer pages;
    private String isbn;
    private LocalDate publishDate;
    private CategoryResponse category;
    private AuthorResponse author;

    public BookResponse(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.summary = book.getSummary();
        this.index = book.getIndex();
        this.price = book.getPrice();
        this.pages = book.getPages();
        this.isbn = book.getIsbn();
        this.publishDate = book.getPublishDate();
        this.category = new CategoryResponse(book.getCategory());
        this.author = new AuthorResponse(book.getAuthor());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getIndex() {
        return index;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public CategoryResponse getCategory() {
        return category;
    }

    public AuthorResponse getAuthor() {
        return author;
    }
}
