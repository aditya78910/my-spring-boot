package com.aditya.myspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.BitSet;

@Document(collection = "ParkingStatus")
@Data
@AllArgsConstructor
public class ParkingStatus {
    @Id
    int parkingLotId;
    int capacity;
    int levels;
    BitSet freeSlots;
}
