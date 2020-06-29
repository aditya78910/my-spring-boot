package com.aditya.myspringboot.service;

import com.aditya.myspringboot.request.ParkingRequest;
import com.aditya.myspringboot.response.ParkingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {
    @Autowired
    ParkingManager parkingManager;

    public ParkingResponse parkVehicle(ParkingRequest parkingRequest){
        int slot = parkingManager.parkCar();
        return new ParkingResponse(slot, parkingRequest.getVehicleId(),parkingRequest.getVehicleType());
    }

    public void unParkVehicle(int slotNumber){
        parkingManager.removeParking(slotNumber);
    }
}
