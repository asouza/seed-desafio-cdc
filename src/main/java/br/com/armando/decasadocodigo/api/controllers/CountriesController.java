package br.com.armando.decasadocodigo.api.controllers;

import br.com.armando.decasadocodigo.api.model.request.CountryRequest;
import br.com.armando.decasadocodigo.api.model.response.CountryResponse;
import br.com.armando.decasadocodigo.domain.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountriesController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CountryResponse insert(@RequestBody @Valid CountryRequest countryRequest) {
        Country country = new Country(countryRequest.getName());
        manager.persist(country);
        return new CountryResponse(country);
    }

}
