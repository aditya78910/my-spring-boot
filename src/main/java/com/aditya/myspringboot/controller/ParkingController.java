package com.aditya.myspringboot.controller;

import com.aditya.myspringboot.request.ParkingRequest;
import com.aditya.myspringboot.response.ParkingResponse;
import com.aditya.myspringboot.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicle/park")
public class ParkingController {

    @Autowired
    ParkingService parkingService;

    @PostMapping
    public ParkingResponse parkVehicle(@RequestBody ParkingRequest parkingRequest){
        return parkingService.parkVehicle(parkingRequest);
    }

    @DeleteMapping("/{slotNumber}")
    public void unparkVehicle(@PathVariable int slotNumber){
        parkingService.unParkVehicle(slotNumber);
    }
}
