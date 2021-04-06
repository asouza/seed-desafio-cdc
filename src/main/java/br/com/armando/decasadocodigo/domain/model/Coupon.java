package br.com.armando.decasadocodigo.domain.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private Integer percentage;

    @Column(nullable = false)
    private LocalDate expiresAt;

    @Deprecated
    public Coupon() {
    }

    public Coupon(String code, Integer percentage, LocalDate expiresAt) {
        this.code = code;
        this.percentage = percentage;
        this.expiresAt = expiresAt;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }

    public boolean isExpired() {
        return LocalDate.now().compareTo(expiresAt) > 0;
    }

}
