package com.rafaelrodrigues.cursomc.services;

import com.rafaelrodrigues.cursomc.domain.Category;
import com.rafaelrodrigues.cursomc.repositories.CategoryRepository;
import com.rafaelrodrigues.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! ID: " + id + ", Type: " + Category.class.getName()
        ));
    }

    public Category insert(Category category) {
        category.setId(null);
        return categoryRepository.save(category);
    }
}
