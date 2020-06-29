package com.aditya.myspringboot.vehicle;

import com.aditya.myspringboot.vehicle.Vehicle;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class Car extends Vehicle {
    @Override
    public String drive() {
        return "Driving a car";
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    @Lookup
    public Tyre getTyre() {
        return null;
    }
}
