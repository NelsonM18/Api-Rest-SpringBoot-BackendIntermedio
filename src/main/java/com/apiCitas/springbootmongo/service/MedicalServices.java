package com.apiCitas.springbootmongo.service;

import com.apiCitas.springbootmongo.model.Medical;
import com.apiCitas.springbootmongo.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalServices {

    @Autowired
    private MedicalRepository repository;

    public Medical addMedical(Medical medical){
        medical.setMedicalId(UUID.randomUUID().toString().split("-")[0]);
        return this.repository.save(medical);
    }

    public List<Medical> findAllMedicals(){

        return this.repository.findAll();
    }

    public Medical getMedicalById(String medicalId){

        return this.repository.findById(medicalId).get();
    }

    public Medical updateMedical(Medical medicalRequest){
        Medical existingMedical = repository.findById(medicalRequest.getMedicalId()).get();
        existingMedical.setDoctorId(medicalRequest.getDoctorId());
        existingMedical.setPacientId(medicalRequest.getPacientId());
        existingMedical.setSpecialty(medicalRequest.getSpecialty());
        existingMedical.setDate(medicalRequest.getDate());

        return this.repository.save(existingMedical);
    }

    public String deleteMedical(String medicalId){
        this.repository.deleteById(medicalId);

        return medicalId+" - Medical Deleted";
    }
}
