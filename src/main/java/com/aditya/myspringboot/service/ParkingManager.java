package com.aditya.myspringboot.service;

import com.aditya.myspringboot.model.ParkingStatus;
import com.aditya.myspringboot.repository.ParkingStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.BitSet;

@Component
public class ParkingManager {
    @Value("${parking.capacity}")
    int capacity;

    @Value("${parking.levels}")
    int levels;

    BitSet freeSlots;

    @Autowired
    ParkingStatusRepository parkingStatusRepository;




    public static final ParkingManager PARKINGMANAGER = new ParkingManager();

    private ParkingManager(){
        freeSlots = new BitSet();
    }

    public int parkCar(){
         int firstFreeSlot = freeSlots.nextClearBit(0);
         freeSlots.set(firstFreeSlot);
         parkingStatusRepository.save(new ParkingStatus(1,capacity,levels,freeSlots)).block();
         return firstFreeSlot;
    }

    public void removeParking(int parkingNumber){

        freeSlots.clear(parkingNumber);
        parkingStatusRepository.save(new ParkingStatus(1,capacity,levels,freeSlots)).block();

    }
}
