package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.State;

public class StateResponse {

    private Long id;
    private String name;
    private CountryResponse country;

    public StateResponse(State state) {
        this.id = state.getId();
        this.name = state.getName();
        this.country = new CountryResponse(state.getCountry());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CountryResponse getCountry() {
        return country;
    }

}
