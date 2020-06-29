package com.aditya.myspringboot.vehicle.factory;

import com.aditya.myspringboot.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Component
public class VehicleTypeFactory {
    @Autowired
     List<Vehicle> vehicles;

    private static HashMap<String,Vehicle> vehiclesMap = new HashMap<>();

    @PostConstruct
    public void initFactoryCache(){
        for(Vehicle vehicle:vehicles){
            vehiclesMap.put(vehicle.getVehicleType(),vehicle);
        }
    }

    public Vehicle getVehicle(String vehicleType){
        return vehiclesMap.get(vehicleType);
    }

}
