package cryss.dev.author_api.infrastructure.adaptadores.validators;

import cryss.dev.author_api.infrastructure.adaptadores.repositories.SpringAuthorRepositoryJPA;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final SpringAuthorRepositoryJPA repository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
         return !repository.findAuthorByEmail (value).isPresent ();
    }
}
