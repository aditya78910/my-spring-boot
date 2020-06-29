package com.aditya.myspringboot.request;

import com.aditya.myspringboot.model.VehicleType;
import lombok.Data;

@Data
public class ParkingRequest {
    int vehicleId;
    VehicleType vehicleType;
}
