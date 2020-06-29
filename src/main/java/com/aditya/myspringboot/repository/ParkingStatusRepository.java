package com.aditya.myspringboot.repository;

import com.aditya.myspringboot.model.ParkingStatus;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingStatusRepository extends ReactiveMongoRepository<ParkingStatus,String> {
}
