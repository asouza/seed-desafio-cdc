package br.com.armando.decasadocodigo.domain.repository;

import br.com.armando.decasadocodigo.domain.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    /**
     * Retorna o cupom com o código informado.
     * @param code
     * @return
     */
    public Coupon getByCode(String code);

}
