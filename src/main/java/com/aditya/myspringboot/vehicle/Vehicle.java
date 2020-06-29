package com.aditya.myspringboot.vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public  class Vehicle {

    @Autowired
    Tyre tyre;

    public   String drive(){return "";}
    public   String getVehicleType(){return "";}

    public  Tyre getTyre(){
        return tyre;
    }

}
