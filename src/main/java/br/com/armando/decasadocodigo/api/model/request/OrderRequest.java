package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.ExistsId;
import br.com.armando.decasadocodigo.domain.model.Country;
import br.com.armando.decasadocodigo.domain.model.State;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.Assert;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
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

    public OrderRequest(
            @NotBlank @Email String email,
            @NotBlank String name,
            @NotBlank String lastName,
            @NotBlank String document,
            @NotBlank String address,
            @NotBlank String complement,
            @NotNull @ExistsId(domainClass = Country.class, fieldName = "countryId") Long countryId,
            @ExistsId(domainClass = State.class, fieldName = "stateId") Long stateId,
            @NotBlank String phone,
            @NotBlank String cep) {
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

    public boolean documentIsValid() {
        Assert.hasLength(document, "Não é possível validar um documento que não foi preenchido.");

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        return cpfValidator.isValid(document, null) || cnpjValidator.isValid(document, null);
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                ", address='" + address + '\'' +
                ", complement='" + complement + '\'' +
                ", countryId=" + countryId +
                ", stateId=" + stateId +
                ", phone='" + phone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

}
