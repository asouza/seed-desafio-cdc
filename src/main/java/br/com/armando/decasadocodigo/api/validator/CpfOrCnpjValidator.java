package br.com.armando.decasadocodigo.api.validator;

import br.com.armando.decasadocodigo.api.model.request.OrderRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CpfOrCnpjValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return OrderRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) return;

        OrderRequest request = (OrderRequest) target;
        if (!request.documentIsValid()) {
            errors.rejectValue("document", null, "documento precisa ser um CPF ou CNPJ válido.");
        }
    }

}
