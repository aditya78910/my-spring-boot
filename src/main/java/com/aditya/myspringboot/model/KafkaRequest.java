package com.aditya.myspringboot.model;

import lombok.Data;

@Data
public class KafkaRequest {
    private String message;
    private String topic;
}
