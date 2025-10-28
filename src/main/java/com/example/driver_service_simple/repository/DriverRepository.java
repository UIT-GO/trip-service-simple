package com.example.driver_service_simple.repository;

import com.example.driver_service_simple.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver, String> {
}
