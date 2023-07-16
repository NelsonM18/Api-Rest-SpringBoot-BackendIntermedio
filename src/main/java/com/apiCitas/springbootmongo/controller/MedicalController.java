package com.apiCitas.springbootmongo.controller;

import com.apiCitas.springbootmongo.model.Medical;
import com.apiCitas.springbootmongo.service.MedicalServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medical")
public class MedicalController {

    @Autowired
    private MedicalServices services;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Medical createdMedical(@RequestBody Medical medical){
        return services.addMedical(medical);
    }

    @GetMapping
    public List<Medical> getMedicals(){
        return services.findAllMedicals();
    }

    @GetMapping("/{medicalId}")
    public Medical getMedical(@PathVariable String medicalId){
        return services.getMedicalById(medicalId);
    }

    @PutMapping
    public Medical updatedMedical(@RequestBody Medical medical){
        return services.updateMedical(medical);
    }

    @DeleteMapping("/{medicalId}")
    public String deletedMedical(@PathVariable String medicalId){
        return services.deleteMedical(medicalId);
    }
}
