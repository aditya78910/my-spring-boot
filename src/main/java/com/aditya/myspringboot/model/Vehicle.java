package com.aditya.myspringboot.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Vehicle")
@Data
public class Vehicle {

    @Id
    String id;

    Integer vehicleId;

    String vehicleName;

}
