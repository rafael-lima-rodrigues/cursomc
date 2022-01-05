package com.rafaelrodrigues.cursomc.resources;

import com.rafaelrodrigues.cursomc.domain.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @GetMapping
    public List<Category> list(){

        Category category1 = new Category(1, "Computing");
        Category category2 = new Category(2, "Office");

        return Arrays.asList(category1,category2);
    }

}
