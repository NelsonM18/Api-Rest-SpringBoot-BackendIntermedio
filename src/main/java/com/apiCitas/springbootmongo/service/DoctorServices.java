package com.apiCitas.springbootmongo.service;

import com.apiCitas.springbootmongo.model.Doctor;
import com.apiCitas.springbootmongo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServices {

    @Autowired
    private DoctorRepository repository;

    public Doctor addDoctor(Doctor doctor){
        doctor.setDoctorId(UUID.randomUUID().toString().split("-")[0]);
        return this.repository.save(doctor);
    }

    public List<Doctor> findAllDoctors(){
        return this.repository.findAll();
    }

    public Doctor getDoctorById(String doctorId){
        return this.repository.findById(doctorId).get();
    }

    public Doctor updateDoctor(Doctor doctorRequest){
        Doctor existingDoctor = repository.findById(doctorRequest.getDoctorId()).get();
        existingDoctor.setFullname(doctorRequest.getFullname());
        existingDoctor.setSpeciality(doctorRequest.getSpeciality());
        existingDoctor.setRoom(doctorRequest.getRoom());
        existingDoctor.setEmail(doctorRequest.getEmail());

        return this.repository.save(existingDoctor);
    }

    public String deleteDoctor(String doctorId){
        this.repository.deleteById(doctorId);

        return  doctorId+" - Doctor Deleted";
    }
}
