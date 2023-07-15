package com.apiCitas.springbootmongo.controller;

import com.apiCitas.springbootmongo.model.Doctor;
import com.apiCitas.springbootmongo.service.DoctorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorServices services;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor createdDoctor(@RequestBody Doctor doctor){
        return  services.addDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getDoctors(){
        return  services.findAllDoctors();
    }

    @GetMapping("/{doctorId}")
    public Doctor getDoctor(@PathVariable String doctorId){
        return services.getDoctorById(doctorId);
    }

    @PutMapping
    public Doctor updatedDoctor(@RequestBody Doctor doctor){
        return services.updateDoctor(doctor);
    }

    @DeleteMapping("/{doctorId}")
    public String deletedDoctor(@PathVariable String doctorId){
        return services.deleteDoctor(doctorId);
    }
}
