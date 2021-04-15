package br.com.armando.decasadocodigo;

import br.com.armando.decasadocodigo.api.model.request.OrderItemRequest;
import br.com.armando.decasadocodigo.api.model.request.OrderRequest;
import br.com.armando.decasadocodigo.api.model.request.PurchaseRequest;
import br.com.armando.decasadocodigo.api.validator.StateInCountryValidator;
import br.com.armando.decasadocodigo.domain.model.Country;
import br.com.armando.decasadocodigo.domain.model.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class StateInCountryValidatorTest {

    private EntityManager manager = Mockito.mock(EntityManager.class);
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
    private Country country = new Country("País");

    @Test
    @DisplayName("Não deveria passar caso já tenha algum erro")
    void test1() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");
        errors.reject("country");

        StateInCountryValidator stateInCountryValidator = new StateInCountryValidator();
        stateInCountryValidator.validate(purchaseRequest, errors);

        Assertions.assertTrue(errors.getAllErrors().size() == 1);
        Assertions.assertEquals("country", errors.getGlobalErrors().get(0).getCode());
    }

    @Test
    @DisplayName("Deveria passar se o país não tem estado associado e o id do estado não foi informado.")
    void test2() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");

        StateInCountryValidator stateInCountryValidator = new StateInCountryValidator();
        ReflectionTestUtils.setField(stateInCountryValidator, "manager", manager);
        Mockito.when(manager.find(Country.class, 1L)).thenReturn(country);
        ReflectionTestUtils.setField(purchaseRequest, "stateId", null);
        stateInCountryValidator.validate(purchaseRequest, errors);

        Assertions.assertFalse(errors.hasErrors());
    }

    @Test
    @DisplayName("Não deveria passar se o país tem algum estado associado e o id do estado não foi informado.")
    void test3() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");

        StateInCountryValidator stateInCountryValidator = new StateInCountryValidator();
        ReflectionTestUtils.setField(stateInCountryValidator, "manager", manager);
        Mockito.when(manager.find(Country.class, 1L)).thenReturn(country);
        ReflectionTestUtils.setField(country, "states", Set.of(new State("estado", country)));
        ReflectionTestUtils.setField(purchaseRequest, "stateId", null);
        stateInCountryValidator.validate(purchaseRequest, errors);

        Assertions.assertTrue(errors.getAllErrors().size() == 1);
        Assertions.assertEquals("Não pode ser nulo para o país informado", errors.getFieldError("stateId").getDefaultMessage());
    }

    @Test
    @DisplayName("Não deveria passar se estado não pertence ao país informado.")
    void test4() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");

        StateInCountryValidator stateInCountryValidator = new StateInCountryValidator();
        ReflectionTestUtils.setField(stateInCountryValidator, "manager", manager);
        Mockito.when(manager.find(Country.class, 1L)).thenReturn(country);
        Mockito.when(manager.find(State.class, 1L)).thenReturn(new State("estado", new Country("Novo País")));
        stateInCountryValidator.validate(purchaseRequest, errors);

        Assertions.assertTrue(errors.getAllErrors().size() == 1);
        Assertions.assertEquals("Estado não pertence ao país informado.", errors.getFieldError("stateId").getDefaultMessage());
    }

    @Test
    @DisplayName("Deveria passar se o estado pertence ao país informado")
    void test5() {
        Errors errors = new BeanPropertyBindingResult(purchaseRequest, "target");

        StateInCountryValidator stateInCountryValidator = new StateInCountryValidator();
        ReflectionTestUtils.setField(stateInCountryValidator, "manager", manager);
        Mockito.when(manager.find(Country.class, 1L)).thenReturn(country);
        Mockito.when(manager.find(State.class, 1L)).thenReturn(new State("estado", country));
        stateInCountryValidator.validate(purchaseRequest, errors);

        Assertions.assertFalse(errors.hasErrors());
    }

}
