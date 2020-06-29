package com.aditya.myspringboot.repository;

import com.aditya.myspringboot.model.Vehicle;
import com.aditya.myspringboot.model.VehicleSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;

public class VehicleRepositoryImpl implements VehicleCustomRepository {
    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Flux<Vehicle> searchVehicles(VehicleSearch search) {
        if(!ObjectUtils.isEmpty(search.getIds()))
            return reactiveMongoTemplate.find(new Query(Criteria.where("_id").in(search.getIds())), Vehicle.class);
        return reactiveMongoTemplate.findAll(Vehicle.class);
    }

}
