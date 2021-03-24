package br.com.armando.decasadocodigo.api.controller;

import br.com.armando.decasadocodigo.api.model.request.CategoryRequest;
import br.com.armando.decasadocodigo.api.validator.DuplicateNameCategoryValidator;
import br.com.armando.decasadocodigo.domain.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private DuplicateNameCategoryValidator duplicateNameCategoryValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(duplicateNameCategoryValidator);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public String insert(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = categoryRequest.toModel();
        manager.persist(category);
        return category.toString();
    }

}
