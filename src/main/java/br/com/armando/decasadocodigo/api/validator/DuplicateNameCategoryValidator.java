package br.com.armando.decasadocodigo.api.validator;

import br.com.armando.decasadocodigo.api.model.request.CategoryRequest;
import br.com.armando.decasadocodigo.domain.model.Category;
import br.com.armando.decasadocodigo.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class DuplicateNameCategoryValidator implements Validator {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoryRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Spring vai rodar os erros de validação padrão antes, se já encontrar, nem roda o meu validate...
        if (errors.hasErrors()) {
            return;
        }

        CategoryRequest categoryRequest = (CategoryRequest) target;
        Optional<Category> possibleCategory = categoryRepository.findByName(categoryRequest.getName());
        if (possibleCategory.isPresent()) {
            errors.rejectValue("name", "Category.DuplicateName", "O nome dessa categoria já existe.");
        }
    }

}
