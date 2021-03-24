package br.com.armando.decasadocodigo.api.validator;

import br.com.armando.decasadocodigo.api.model.request.AuthorRequest;
import br.com.armando.decasadocodigo.domain.model.Author;
import br.com.armando.decasadocodigo.domain.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class DuplicateEmailAuthorValidator implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AuthorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Spring vai rodar os erros de validação padrão antes, se já encontrar, nem roda o meu validate...
        if (errors.hasErrors()) {
            return;
        }

        AuthorRequest authorRequest = (AuthorRequest) target;
        Optional<Author> possibleAuthor = authorRepository.findByEmail(authorRequest.getEmail());
        if (possibleAuthor.isPresent()) {
            errors.rejectValue("email", "Author.DuplicateEmail", "O email informado já está vinculado a um author no sistema.");
        }
    }

}
