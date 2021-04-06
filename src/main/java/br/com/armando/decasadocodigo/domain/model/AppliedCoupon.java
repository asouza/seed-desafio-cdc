package br.com.armando.decasadocodigo.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Embeddable
public class AppliedCoupon {

    @ManyToOne
    private Coupon coupon;

    @NotNull
    @Positive
    private Integer percentage;

    @NotNull
    @Future
    private LocalDate expiresAt;

    @Deprecated
    public AppliedCoupon() {
    }

    public AppliedCoupon(Coupon coupon) {
        this.coupon = coupon;
        this.percentage = coupon.getPercentage();
        this.expiresAt = coupon.getExpiresAt();
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }
}
