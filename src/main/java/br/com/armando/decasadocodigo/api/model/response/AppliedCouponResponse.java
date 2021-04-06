package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.AppliedCoupon;

import java.time.LocalDate;

public class AppliedCouponResponse {

    private CouponSummaryResponse coupon;
    private Integer percentage;
    private LocalDate expiresAt;

    public AppliedCouponResponse(AppliedCoupon appliedCoupon) {
        this.coupon = new CouponSummaryResponse(appliedCoupon.getCoupon());
        this.percentage = appliedCoupon.getPercentage();
        this.expiresAt = appliedCoupon.getExpiresAt();
    }

    public CouponSummaryResponse getCoupon() {
        return coupon;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public LocalDate getExpiresAt() {
        return expiresAt;
    }
}
