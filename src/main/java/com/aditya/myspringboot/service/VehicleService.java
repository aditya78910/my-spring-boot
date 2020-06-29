package com.aditya.myspringboot.service;

import com.aditya.myspringboot.constants.ApplicationConstants;
import com.aditya.myspringboot.model.Vehicle;
import com.aditya.myspringboot.model.VehicleSearch;
import com.aditya.myspringboot.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    NSService nsService;

    @Autowired
    KafkaService kafkaService;

    @Transactional
    public Mono<Vehicle> addVehicle(Vehicle vehicle){
        //
        /*nsService.getNextSequence(ApplicationConstants.MODEL_VEHICLE)
                .doOnNext(sequence -> vehicle.setVehicleId(sequence.getSequence()))
                .then( vehicleRepository.insert(vehicle))
                .doOnNext(emittedVehicle -> {
                     log.info("Vehicle id is "+emittedVehicle.getVehicleId());
                     kafkaService.produce(null, emittedVehicle);
                }).block();
        */

        return nsService.getNextSequence(ApplicationConstants.MODEL_VEHICLE)
                .flatMap(sequence -> {
                    vehicle.setVehicleId(sequence.getSequence());
                    return vehicleRepository.insert(vehicle);
                })
                .doOnNext(emittedVehicle -> {
                    log.info("Vehicle id is "+emittedVehicle.getVehicleId());
                    Assert.isTrue(emittedVehicle.getVehicleName().contains("honda"), "car is not honda");})
                .doOnNext(emittedVehicle -> {

                    log.info("Vehicle id is "+ emittedVehicle.getVehicleId());
                    kafkaService.produce(null, emittedVehicle);
                }).doOnNext(emittedVehicle-> log.info("hello World"));
    }

    @Transactional
    public Flux<Vehicle> addVehiclesTransactionally(List<Vehicle> vehicles){
        //
        /*nsService.getNextSequence(ApplicationConstants.MODEL_VEHICLE)
                .doOnNext(sequence -> vehicle.setVehicleId(sequence.getSequence()))
                .then( vehicleRepository.insert(vehicle))
                .doOnNext(emittedVehicle -> {
                     log.info("Vehicle id is "+emittedVehicle.getVehicleId());
                     kafkaService.produce(null, emittedVehicle);
                }).block();
        */

        return vehicleRepository.saveAll(vehicles)
                .doOnNext(vehicle -> Assert.isTrue(vehicle.getVehicleName().contains("honda"), "should contain honda"));

    }

    public Flux<Vehicle> searchVehicles(VehicleSearch search) {
        return vehicleRepository.searchVehicles(search);
    }
}
