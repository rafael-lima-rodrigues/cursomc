package com.rafaelrodrigues.cursomc.repositories;

import com.rafaelrodrigues.cursomc.domain.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Integer> {
}
