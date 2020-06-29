package com.aditya.myspringboot.repository;

import com.aditya.myspringboot.model.Vehicle;
import com.aditya.myspringboot.model.VehicleSearch;
import reactor.core.publisher.Flux;


public interface VehicleCustomRepository {

    Flux<Vehicle> searchVehicles(VehicleSearch search);
}
