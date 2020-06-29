package com.aditya.myspringboot.response;

import com.aditya.myspringboot.model.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParkingResponse {
    int parkingSlot;
    int vehicleId;
    VehicleType vehicleType;
}
