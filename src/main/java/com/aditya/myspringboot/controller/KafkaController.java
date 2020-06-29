package com.aditya.myspringboot.controller;

import com.aditya.myspringboot.model.KafkaRequest;
import com.aditya.myspringboot.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    KafkaService kafkaService;

    @PostMapping("/produce")
    public String produce(@RequestBody KafkaRequest request) {
        //kafkaService.produce(request.getTopic(),request.getMessage());
        return "produced "+request.getMessage();
    }
}
