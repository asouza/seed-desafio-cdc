package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class OrderTest {

    @DisplayName("Instancia um pedido com total válido")
    @ParameterizedTest
    @CsvSource({
            "10, 5, 50, true",
            "10, 5, 49.99, false",
            "10, 5, 50.01, false"
    })
    void test1(BigDecimal bookPrice, int orderItemQuantity, BigDecimal expectedTotal, Boolean totalEqual) {
        Book book = new Book(
                "titulo",
                "resumo",
                "sumario",
                bookPrice,
                100,
                "ISBN",
                LocalDate.now().plusDays(10),
                new Category("categoria"),
                new Author("Autor", "autor@email.com", "testando")
        );
        Set<OrderItem> items = Set.of(new OrderItem(book, orderItemQuantity));
        Order order = new Order(
                Mockito.mock(Purchase.class),
                items
        );

        Assertions.assertEquals(totalEqual, order.totalEqual(expectedTotal));
    }

    @Test
    @DisplayName("Instancia um pedido sem items")
    void test2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Order(Mockito.mock(Purchase.class), new HashSet<>());
        });
    }

}
