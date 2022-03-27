package com.rafaelrodrigues.cursomc.repositories;

import com.rafaelrodrigues.cursomc.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
