package com.rafaelrodrigues.cursomc.repositories;

import com.rafaelrodrigues.cursomc.domain.City;
import com.rafaelrodrigues.cursomc.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}
