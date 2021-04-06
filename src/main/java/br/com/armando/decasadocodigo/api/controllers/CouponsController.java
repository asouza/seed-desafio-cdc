package br.com.armando.decasadocodigo.api.controllers;

import br.com.armando.decasadocodigo.api.model.request.CouponRequest;
import br.com.armando.decasadocodigo.api.model.response.CouponResponse;
import br.com.armando.decasadocodigo.domain.model.Coupon;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/coupons")
public class CouponsController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CouponResponse insert(@RequestBody @Valid CouponRequest couponRequest) {
        Coupon coupon = couponRequest.toModel();
        manager.persist(coupon);
        return new CouponResponse(coupon);
    }

}
