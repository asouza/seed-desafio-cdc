package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.UniqueValue;
import br.com.armando.decasadocodigo.domain.model.Coupon;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

public class CouponRequest {

    @NotBlank
    @UniqueValue(domainClass = Coupon.class, fieldName = "code")
    private String code;

    @NotNull
    @Positive
    private Integer percentage;

    @NotNull
    @Future
    private LocalDate expiresAt;

    public CouponRequest(
            @NotBlank @UniqueValue(domainClass = Coupon.class, fieldName = "code") String code,
            @NotNull @Positive Integer percentage,
            @NotNull @Future LocalDate expiresAt
    ) {
        this.code = code;
        this.percentage = percentage;
        this.expiresAt = expiresAt;
    }

    public Coupon toModel() {
        return new Coupon(
                code,
                percentage,
                expiresAt
        );
    }

}
