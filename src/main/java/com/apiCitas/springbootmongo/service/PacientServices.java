package com.apiCitas.springbootmongo.service;

import com.apiCitas.springbootmongo.model.Pacient;
import com.apiCitas.springbootmongo.repository.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PacientServices {

    @Autowired
    private PacientRepository repository;

    public Pacient addPacient(Pacient pacient){
        pacient.setPacientId(UUID.randomUUID().toString().split("-")[0]);
        return this.repository.save(pacient);
    }

    public List<Pacient> findAllPacients(){
        return  this.repository.findAll();
    }

    public Pacient getPacientById(String pacientId){
        return this.repository.findById(pacientId).get();
    }

    public Pacient updatePacient(Pacient pacientRequest){
        Pacient existingPacient = repository.findById(pacientRequest.getPacientId()).get();
        existingPacient.setFullname(pacientRequest.getFullname());
        existingPacient.setDocument(pacientRequest.getDocument());
        existingPacient.setAge(pacientRequest.getAge());
        existingPacient.setPhone(pacientRequest.getPhone());

        return  this.repository.save(existingPacient);
    }

    public String deletePacient(String pacientId){
        this.repository.deleteById(pacientId);

        return pacientId+" - Pacient Deleted";
    }
}
