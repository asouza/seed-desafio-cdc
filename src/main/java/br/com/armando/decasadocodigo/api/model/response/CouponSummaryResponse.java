package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.Coupon;

public class CouponSummaryResponse {

    private Long id;
    private String code;

    public CouponSummaryResponse(Coupon coupon) {
        id = coupon.getId();
        code = coupon.getCode();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

}
