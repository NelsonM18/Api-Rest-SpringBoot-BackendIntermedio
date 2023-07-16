package com.apiCitas.springbootmongo.repository;

import com.apiCitas.springbootmongo.model.Medical;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicalRepository extends MongoRepository<Medical, String> {
}
