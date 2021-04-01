package br.com.armando.decasadocodigo.api.validator;

import br.com.armando.decasadocodigo.api.model.request.OrderRequest;
import br.com.armando.decasadocodigo.domain.model.Country;
import br.com.armando.decasadocodigo.domain.model.State;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class StateInCountryValidator implements Validator {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return OrderRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        OrderRequest request = (OrderRequest) target;
        Country country = manager.find(Country.class, request.getCountryId());
        if (!country.hasAnyState() && request.getStateId() == null) return;

        if (request.getStateId() == null) {
            errors.rejectValue("stateId", null, "Não pode ser nulo para o país informado");
            return;
        }

        State state = manager.find(State.class, request.getStateId());
        if (!state.belongsToCountry(country)) {
            errors.rejectValue("stateId", null, "Estado não pertence ao país informado.");
        }
    }

}
