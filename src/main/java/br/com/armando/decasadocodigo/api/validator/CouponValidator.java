package br.com.armando.decasadocodigo.api.validator;

import br.com.armando.decasadocodigo.api.model.request.PurchaseRequest;
import br.com.armando.decasadocodigo.domain.model.Coupon;
import br.com.armando.decasadocodigo.domain.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CouponValidator implements Validator {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return PurchaseRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        PurchaseRequest request = (PurchaseRequest) target;
        if (!request.hasCouponCode()) return;

        Coupon coupon = couponRepository.getByCode(request.getCouponCode());
        if (coupon == null) {
            errors.rejectValue("couponCode", null, "Esse cupom não existe.");
            return;
        }

        if (coupon.isExpired()) errors.rejectValue("couponCode", null, "Cupom expirado");
    }

}
