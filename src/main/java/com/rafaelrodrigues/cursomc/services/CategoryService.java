package com.rafaelrodrigues.cursomc.services;

import com.rafaelrodrigues.cursomc.domain.Category;
import com.rafaelrodrigues.cursomc.repositories.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public Category findById(Integer id){
        Optional<Category> obj = categoryRespository.findById(id);
        return obj.orElse(null);
    }
}
