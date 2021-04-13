package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.api.model.request.OrderItemRequest;
import br.com.armando.decasadocodigo.api.model.request.OrderRequest;
import br.com.armando.decasadocodigo.api.model.request.PurchaseRequest;
import br.com.armando.decasadocodigo.domain.model.*;
import br.com.armando.decasadocodigo.domain.repository.CouponRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PurchaseRequestTest {

    private EntityManager manager = Mockito.mock(EntityManager.class);
    private CouponRepository couponRepository = Mockito.mock(CouponRepository.class);

    private List<OrderItemRequest> items = List.of(new OrderItemRequest(1L, 5));
    private OrderRequest orderRequest = new OrderRequest(
            new BigDecimal(25),
            items
    );

    private Country country = new Country("País");
    private Author author = new Author("nome", "email@gmail.com", "description");
    private Category category = new Category("categoria");
    private Book book = new Book(
            "título",
            "resumo",
            "sumário",
            new BigDecimal(5),
            100,
            "ISBN",
            LocalDate.now().plusDays(1),
            category,
            author
    );

    {
        Mockito.when(manager.find(Country.class, 1L)).thenReturn(country);
        Mockito.when(manager.find(Book.class, 1L)).thenReturn(book);
        Mockito.when(manager.find(State.class, 1L)).thenReturn(new State("estado", country));
        Mockito.when(couponRepository.getByCode("VALE10")).thenReturn(
                new Coupon("VALE10", 10, LocalDate.now().plusDays(1))
        );
    }

    @Test
    @DisplayName("Cria uma compra com estado e cupom")
    void test1() {
        PurchaseRequest purchaseRequest = new PurchaseRequest(
                "armando@gmail.com",
                "Armando",
                "Del Col",
                "42201968896",
                "Rua Casper",
                "",
                1L,
                1L,
                "1140332585",
                "12458999",
                orderRequest,
                "VALE10"
        );
        Purchase purchase = purchaseRequest.toModel(manager, couponRepository);

        Assertions.assertNotNull(purchase);
        Mockito.verify(manager).find(State.class, 1L);
        Mockito.verify(couponRepository).getByCode("VALE10");
    }

    @Test
    @DisplayName("Cria uma compra com estado e sem cupom")
    void test2() {
        PurchaseRequest purchaseRequest = new PurchaseRequest(
                "armando@gmail.com",
                "Armando",
                "Del Col",
                "42201968896",
                "Rua Casper",
                "",
                1L,
                1L,
                "1140332585",
                "12458999",
                orderRequest,
                null
        );
        Purchase purchase = purchaseRequest.toModel(manager, couponRepository);

        Assertions.assertNotNull(purchase);
        Mockito.verify(manager).find(State.class, 1L);
        Assertions.assertNull(purchase.getAppliedCoupon());
        Mockito.verify(couponRepository, Mockito.never()).getByCode(Mockito.anyString());
    }

    @Test
    @DisplayName("Cria uma compra sem estado e com cupom")
    void test3() {
        PurchaseRequest purchaseRequest = new PurchaseRequest(
                "armando@gmail.com",
                "Armando",
                "Del Col",
                "42201968896",
                "Rua Casper",
                "",
                1L,
                null,
                "1140332585",
                "12458999",
                orderRequest,
                "VALE10"
        );
        Purchase purchase = purchaseRequest.toModel(manager, couponRepository);

        Assertions.assertNotNull(purchase);
        Mockito.verify(couponRepository).getByCode("VALE10");
        Mockito.verify(manager, Mockito.never()).find(Mockito.eq(State.class), Mockito.anyLong());
        Assertions.assertNull(purchase.getState());
    }

}
