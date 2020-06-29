package com.aditya.myspringboot.service;

import com.aditya.myspringboot.vehicle.Vehicle;
import com.aditya.myspringboot.vehicle.factory.VehicleTypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstService {

    @Autowired
    KafkaService kafkaService;

    @Autowired
    VehicleTypeFactory vehicleTypeFactory;

    public String getCar(String carType){
        Vehicle vehicle = vehicleTypeFactory.getVehicle(carType);
//        System.out.println(vehicle.getVehicleType()+" ---Tyre = " + vehicle.getTyre());
//        System.out.println();
        //kafkaService.produce("first_topic","hello there");
        return vehicle.drive();
    }

    public String consume(){
        kafkaService.consume("first_topic");
        return "hello";
    }

    public void produce(String message){
        //kafkaService.produce("first_topic", message);
    }
}
