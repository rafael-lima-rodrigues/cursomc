package com.rafaelrodrigues.cursomc.services;

import com.rafaelrodrigues.cursomc.domain.Demand;
import com.rafaelrodrigues.cursomc.repositories.DemandRepository;
import com.rafaelrodrigues.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DemandService {

    @Autowired
    private DemandRepository demandRepository;

    public Demand findById(Integer id) {
        Optional<Demand> obj = demandRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! ID: " + id + ", Type: " + Demand.class.getName()
        ));
    }
}
