package com.aditya.myspringboot.service;

import com.aditya.myspringboot.model.NextSequence;
import com.aditya.myspringboot.repository.NSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class NSService {
    @Autowired
    NSRepository nsRepository;

    public Mono<NextSequence> getNextSequence(String model){
        return nsRepository.getNextSequence(model);
    }
}
