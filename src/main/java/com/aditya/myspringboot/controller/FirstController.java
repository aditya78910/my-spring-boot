package com.aditya.myspringboot.controller;

import com.aditya.myspringboot.config.MyConfiguration;
import com.aditya.myspringboot.service.FirstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {
    @Autowired
    FirstService firstService;

    @Autowired
    MyConfiguration myConfiguration;

    @GetMapping("/first")
    public String sayHello(@RequestParam String carType) {
        return firstService.getCar(carType);

        //return myConfiguration.getConnection()+myConfiguration.getHost()+myConfiguration.getPort();
    }

    @GetMapping("/consume")
    public String consume() {
        //return firstService.consume();
        return "consumed";
        //return myConfiguration.getConnection()+myConfiguration.getHost()+myConfiguration.getPort();
    }

    @GetMapping("/")
    public String blank() {
       return "BLANKkkkkkkkkkkk";
    }
}
