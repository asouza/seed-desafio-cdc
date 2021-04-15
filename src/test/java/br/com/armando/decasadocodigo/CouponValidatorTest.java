package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.api.model.request.OrderItemRequest;
import br.com.armando.decasadocodigo.api.model.request.OrderRequest;
import br.com.armando.decasadocodigo.api.model.request.PurchaseRequest;
import br.com.armando.decasadocodigo.api.validator.CouponValidator;
import br.com.armando.decasadocodigo.domain.model.Coupon;
import br.com.armando.decasadocodigo.domain.repository.CouponRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class CouponValidatorTest {

    private CouponRepository couponRepository = Mockito.mock(CouponRepository.class);
    private List<OrderItemRequest> items = List.of(new OrderItemRequest(1L, 10));
    private OrderRequest orderRequest = new OrderRequest(new BigDecimal(100), items);
    private PurchaseRequest purchaseRequest = new PurchaseRequest(
            "test@email.com",
            "teste",
            "lastName",
            "00000000000",
            "Endereço",
            "Complemento",
            1L,
            1L,
            "11998703094",
            "129785555",
            orderRequest,
            "CUPOM10"
    );

    @Test
    @DisplayName("Deveria parar caso já tenha erro")
    void test1() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");
        errors.reject("couponCode");

        CouponValidator couponValidator = new CouponValidator();
        couponValidator.validate(purchaseRequest, errors);

        Assertions.assertTrue(errors.getAllErrors().size() == 1);
        Assertions.assertEquals("couponCode", errors.getGlobalErrors().get(0).getCode());
    }

    @Test
    @DisplayName("Deveria passar caso não tenha código do cupom informado")
    void test2() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");
        CouponValidator couponValidator = new CouponValidator();
        ReflectionTestUtils.setField(couponValidator, "couponRepository", couponRepository);
        ReflectionTestUtils.setField(purchaseRequest, "couponCode", null);
        couponValidator.validate(purchaseRequest, errors);

        Assertions.assertFalse(errors.hasErrors());
    }

    @Test
    @DisplayName("Não deveria passar caso cupom não exista")
    void test3() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");
        CouponValidator couponValidator = new CouponValidator();
        ReflectionTestUtils.setField(couponValidator, "couponRepository", couponRepository);
        couponValidator.validate(purchaseRequest, errors);

        Assertions.assertTrue(errors.hasErrors());
        Assertions.assertEquals("Esse cupom não existe.", errors.getFieldError("couponCode").getDefaultMessage());
    }

    @Test
    @DisplayName("Não deveria passar caso cupom exteja expirado")
    void test4() {
        Coupon coupon = new Coupon("CUPOM10", 10, LocalDate.now());
        ReflectionTestUtils.setField(coupon, "expiresAt", LocalDate.now().minusDays(1));
        Mockito.when(couponRepository.getByCode("CUPOM10")).thenReturn(coupon);

        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");
        CouponValidator couponValidator = new CouponValidator();
        ReflectionTestUtils.setField(couponValidator, "couponRepository", couponRepository);
        couponValidator.validate(purchaseRequest, errors);

        Assertions.assertTrue(errors.hasErrors());
        Assertions.assertEquals("Cupom expirado", errors.getFieldError("couponCode").getDefaultMessage());
    }

    @Test
    @DisplayName("Deveria passar caso cupom esteja válido.")
    void test5() {
        Coupon coupon = new Coupon("CUPOM10", 10, LocalDate.now());
        Mockito.when(couponRepository.getByCode("CUPOM10")).thenReturn(coupon);

        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");
        CouponValidator couponValidator = new CouponValidator();
        ReflectionTestUtils.setField(couponValidator, "couponRepository", couponRepository);
        couponValidator.validate(purchaseRequest, errors);

        Assertions.assertFalse(errors.hasErrors());
    }

}
