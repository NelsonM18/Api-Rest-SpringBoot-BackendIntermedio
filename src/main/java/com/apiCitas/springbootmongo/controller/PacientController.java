package com.apiCitas.springbootmongo.controller;

import com.apiCitas.springbootmongo.model.Pacient;
import com.apiCitas.springbootmongo.service.PacientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacient")
public class PacientController {

    @Autowired
    private PacientServices services;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pacient created(@RequestBody Pacient pacient){
        return services.addPacient(pacient);
    }

    @GetMapping
    public List<Pacient> getPacients(){
        return this.services.findAllPacients();
    }

    @GetMapping("{/pacientId}")
    public Pacient getPacient(@PathVariable String pacientId){
        return  services.getPacientById(pacientId);
    }

    @PutMapping
    public Pacient updatedPacient(@RequestBody Pacient pacient){
        return  services.updatePacient(pacient);
    }

    @DeleteMapping("/{pacientId}")
    public String deletedDoctor(@PathVariable String pacientId){
        return services.deletePacient(pacientId);
    }
}
