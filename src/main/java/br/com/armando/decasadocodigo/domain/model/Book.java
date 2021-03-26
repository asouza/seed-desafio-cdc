package br.com.armando.decasadocodigo.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT", precision = 500)
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String index;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private LocalDate publishDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    public Book(String title, String summary, String index, BigDecimal price, Integer pages, String isbn, LocalDate publishDate, Category category, Author author) {
        this.title = title;
        this.summary = summary;
        this.index = index;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.category = category;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", index='" + index + '\'' +
                ", price=" + price +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", category=" + category +
                ", author=" + author +
                '}';
    }
}
