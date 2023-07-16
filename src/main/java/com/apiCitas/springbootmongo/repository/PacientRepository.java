package com.apiCitas.springbootmongo.repository;

import com.apiCitas.springbootmongo.model.Pacient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacientRepository extends MongoRepository<Pacient, String> {
}
