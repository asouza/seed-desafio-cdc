package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.Coupon;

import java.time.LocalDate;

public class CouponResponse {

    private Long id;
    private String code;
    private Integer percentage;
    private LocalDate expiresAt;

    public CouponResponse(Coupon coupon) {
        id = coupon.getId();
        code = coupon.getCode();
        percentage = coupon.getPercentage();
        expiresAt = coupon.getExpiresAt();
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

}
