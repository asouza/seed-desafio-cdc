package br.com.armando.decasadocodigo.api.controllers;

import br.com.armando.decasadocodigo.api.model.request.OrderRequest;
import br.com.armando.decasadocodigo.api.validator.CpfOrCnpjValidator;
import br.com.armando.decasadocodigo.api.validator.StateInCountryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private StateInCountryValidator stateInCountryValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new CpfOrCnpjValidator());
        binder.addValidators(stateInCountryValidator);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String insert(@RequestBody @Valid OrderRequest orderRequest) {
        return orderRequest.toString();
    }

}
