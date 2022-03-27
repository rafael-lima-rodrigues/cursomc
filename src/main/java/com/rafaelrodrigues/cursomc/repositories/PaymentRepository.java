package com.rafaelrodrigues.cursomc.repositories;

import com.rafaelrodrigues.cursomc.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
