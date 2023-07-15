package com.apiCitas.springbootmongo.repository;

import com.apiCitas.springbootmongo.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {
}
