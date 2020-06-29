package com.aditya.myspringboot.controller;

import com.aditya.myspringboot.model.Vehicle;
import com.aditya.myspringboot.model.VehicleSearch;
import com.aditya.myspringboot.service.VehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @PostMapping
    public Mono<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
        log.info("Adding vehicle "+vehicle.getVehicleName());
         return vehicleService.addVehicle(vehicle);
    }
    @PostMapping("/bulk")
    public Flux<Vehicle> addVehicles(@RequestBody List<Vehicle> vehicles){
        log.info("Adding vehicles "+vehicles);
        return vehicleService.addVehiclesTransactionally(vehicles);
    }

    @GetMapping
    public Flux<Vehicle> getVehicles(@ModelAttribute VehicleSearch search){
        return vehicleService.searchVehicles(search);
    }
}
