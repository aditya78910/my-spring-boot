package com.aditya.myspringboot.vehicle;

import org.springframework.stereotype.Component;

@Component
public class Truck extends Vehicle {
    @Override
    public String drive() {
        return "Driving a Truck..be careful";
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }

}
