package com.rafaelrodrigues.cursomc.services;

import com.rafaelrodrigues.cursomc.domain.Customer;
import com.rafaelrodrigues.cursomc.repositories.CustomerRepository;
import com.rafaelrodrigues.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRespository;

    public Customer findById(Integer id) {
        Optional<Customer> obj = customerRespository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! ID: " + id + ", Type: " + Customer.class.getName()
        ));
    }
}
