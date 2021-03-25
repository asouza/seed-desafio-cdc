package br.com.armando.decasadocodigo.api.model.request;

import br.com.armando.decasadocodigo.api.validator.UniqueValue;
import br.com.armando.decasadocodigo.domain.model.Category;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    private String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoryRequest(String name) {
        this.name = name;
    }

    public Category toModel() {
        Category category = new Category(this.name);
        return category;
    }

    public String getName() {
        return name;
    }
}
