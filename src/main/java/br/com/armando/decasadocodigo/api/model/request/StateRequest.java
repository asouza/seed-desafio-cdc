package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.ExistsId;
import br.com.armando.decasadocodigo.domain.model.Country;
import br.com.armando.decasadocodigo.domain.model.State;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateRequest {

    @NotBlank
    private String name;

    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "countryId")
    private Long countryId;

    public StateRequest(@NotBlank String name, @NotNull @ExistsId(domainClass = Country.class, fieldName = "countryId") Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public State toModel(EntityManager manager) {
        Country possibleCountry = manager.find(Country.class, this.countryId);
        Assert.state(possibleCountry != null, "País informado não foi encontrado no sistema.");

        return new State(this.name, possibleCountry);
    }
}
