package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.Document;
import br.com.armando.decasadocodigo.api.validator.ExistsId;
import br.com.armando.decasadocodigo.domain.model.Country;
import br.com.armando.decasadocodigo.domain.model.Order;
import br.com.armando.decasadocodigo.domain.model.Purchase;
import br.com.armando.decasadocodigo.domain.model.State;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.function.Function;

public class PurchaseRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @Document
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "countryId")
    private Long countryId;

    @ExistsId(domainClass = State.class, fieldName = "stateId")
    private Long stateId;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    @Valid
    @NotNull
    private OrderRequest order;

    public PurchaseRequest(
            @NotBlank @Email String email,
            @NotBlank String name,
            @NotBlank String lastName,
            @NotBlank @Document String document,
            @NotBlank String address,
            @NotBlank String complement,
            @NotNull @ExistsId(domainClass = Country.class, fieldName = "countryId") Long countryId,
            @ExistsId(domainClass = State.class, fieldName = "stateId") Long stateId,
            @NotBlank String phone,
            @NotBlank String cep,
            @Valid @NotNull OrderRequest order) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phone = phone;
        this.cep = cep;
        this.order = order;
    }

    public String getDocument() {
        return document;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public OrderRequest getOrder() {
        return order;
    }

    public Purchase toModel(EntityManager manager) {
        @NotNull Country country = manager.find(Country.class, countryId);
        Function<Purchase, Order> orderCreationFunction = this.order.toModel(manager);
        Purchase purchase = new Purchase(email, name, lastName, document, address, complement, country, phone, cep, orderCreationFunction);
        if (stateId != null) {
            State state = manager.find(State.class, stateId);
            purchase.setState(state);
        }
        return purchase;
    }
}
