package br.com.armando.decasadocodigo.api.controllers;

import br.com.armando.decasadocodigo.api.model.request.PurchaseRequest;
import br.com.armando.decasadocodigo.api.model.response.PurchaseResponse;
import br.com.armando.decasadocodigo.api.validator.CouponValidator;
import br.com.armando.decasadocodigo.api.validator.StateInCountryValidator;
import br.com.armando.decasadocodigo.domain.model.Purchase;
import br.com.armando.decasadocodigo.domain.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/purchases")
public class PurchasesController {

    @Autowired
    private StateInCountryValidator stateInCountryValidator;

    @Autowired
    private CouponValidator couponValidator;

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private CouponRepository couponRepository;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(stateInCountryValidator, couponValidator);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public PurchaseResponse insert(@RequestBody @Valid PurchaseRequest purchaseRequest) {
        Purchase purchase = purchaseRequest.toModel(manager, couponRepository);
        manager.persist(purchase);
        return new PurchaseResponse(purchase);
    }

}
