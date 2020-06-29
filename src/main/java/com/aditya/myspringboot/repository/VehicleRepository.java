package com.aditya.myspringboot.repository;

import com.aditya.myspringboot.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends ReactiveMongoRepository<Vehicle,String>,VehicleCustomRepository {
    //Vehicle insert(Vehicle vehicle);
}
