package com.rafaelrodrigues.cursomc.dto;

import com.rafaelrodrigues.cursomc.domain.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Name is mandatory")
    @Length(min = 5, max = 80, message = "Name must have minimum 5 and maximum 80 character")
    private String name;

    public CategoryDTO() {
    }

    ;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
