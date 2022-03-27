package com.rafaelrodrigues.cursomc.resources;

import com.rafaelrodrigues.cursomc.domain.Customer;
import com.rafaelrodrigues.cursomc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Customer> list(@PathVariable Integer id) {
        var obj = customerService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
