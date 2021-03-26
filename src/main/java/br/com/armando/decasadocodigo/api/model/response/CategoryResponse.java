package br.com.armando.decasadocodigo.api.model.response;

import br.com.armando.decasadocodigo.domain.model.Category;

public class CategoryResponse {

    private Long id;
    private String name;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
