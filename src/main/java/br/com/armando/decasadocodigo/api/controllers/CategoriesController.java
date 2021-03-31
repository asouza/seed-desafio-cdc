package br.com.armando.decasadocodigo.api.controllers;

import br.com.armando.decasadocodigo.api.model.request.CategoryRequest;
import br.com.armando.decasadocodigo.api.model.response.CategoryResponse;
import br.com.armando.decasadocodigo.domain.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/categories")
public class CategoriesController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CategoryResponse insert(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = categoryRequest.toModel();
        manager.persist(category);
        return new CategoryResponse(category);
    }

}
