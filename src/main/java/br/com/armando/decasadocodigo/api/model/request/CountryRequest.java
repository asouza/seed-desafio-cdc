package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.UniqueValue;
import br.com.armando.decasadocodigo.domain.model.Country;

import javax.validation.constraints.NotBlank;

public class CountryRequest {

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    @Deprecated
    public CountryRequest() {
    }

    public CountryRequest(@NotBlank @UniqueValue(domainClass = Country.class, fieldName = "name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
