package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.domain.model.Coupon;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.LocalDate;

public class CouponTest {

    @Test
    @DisplayName("Instanciando um cupom válido")
    void test1() {
        Coupon coupon = new Coupon("123", 10, LocalDate.now());
        Assertions.assertFalse(coupon.isExpired());
    }

    @Test
    @DisplayName("Cupom com data expirada")
    void test2() {
        Coupon coupon = new Coupon("123", 10, LocalDate.now());
        ReflectionTestUtils.setField(coupon, "expiresAt", LocalDate.now().minusDays(1));
        Assertions.assertTrue(coupon.isExpired());
    }

    @Test
    @DisplayName("Istanciano um cupom invalido")
    void test3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Coupon("123", 10, LocalDate.now().minusDays(1));
        });
    }

}
