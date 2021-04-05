package br.com.armando.decasadocodigo.api.controllers;

import br.com.armando.decasadocodigo.api.exceptionhandler.CustomErrorResponseBody;
import br.com.armando.decasadocodigo.api.model.request.StateRequest;
import br.com.armando.decasadocodigo.api.model.response.StateResponse;
import br.com.armando.decasadocodigo.domain.model.State;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/states")
public class StatesController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> insert(@RequestBody @Valid StateRequest stateRequest) {
        if (existsInCountry(stateRequest)) return ResponseEntity.badRequest().body(
                new CustomErrorResponseBody(
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        "Já existe um Estado com esse nome no País informado",
                        OffsetDateTime.now()
                )
        );
        State state = stateRequest.toModel(manager);
        manager.persist(state);
        return ResponseEntity.created(URI.create("/state/" + state.getId())).body(new StateResponse(state));
    }

    private Boolean existsInCountry(StateRequest request) {
         List<State> possibleStates = manager.createQuery("SELECT state FROM State state WHERE state.name = :name AND state.country.id = :countryId", State.class)
                .setParameter("name", request.getName())
                .setParameter("countryId", request.getCountryId())
                .getResultList();
         return !possibleStates.isEmpty();
    }

}
