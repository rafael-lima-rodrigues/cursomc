package com.rafaelrodrigues.cursomc.resources;

import com.rafaelrodrigues.cursomc.domain.Demand;
import com.rafaelrodrigues.cursomc.services.DemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/demands")
public class DemandResource {

    @Autowired
    DemandService demandService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> list(@PathVariable Integer id) {
        Demand obj = demandService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
