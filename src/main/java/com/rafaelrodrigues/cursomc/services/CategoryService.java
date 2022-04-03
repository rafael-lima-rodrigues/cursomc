package com.rafaelrodrigues.cursomc.services;

import com.rafaelrodrigues.cursomc.domain.Category;
import com.rafaelrodrigues.cursomc.repositories.CategoryRepository;
import com.rafaelrodrigues.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Integer id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! ID: " + id + ", Type: " + Category.class.getName()
        ));
    }

    public Category insert(Category category) {
        category.setId(null);
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        categoryExists(category.getId());
        return categoryRepository.save(category);
    }

    public void delete(Integer id) {
        categoryExists(id);
        try {
            categoryRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.rafaelrodrigues.cursomc.services.exceptions.DataIntegrityViolationException(
                    "Is not possible delete category which contains products"
            );
        }
    }

    private void categoryExists(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new ObjectNotFoundException(
                    "Object not found! ID: " + id + ", Type: " + Category.class.getName()
            );
        }
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
