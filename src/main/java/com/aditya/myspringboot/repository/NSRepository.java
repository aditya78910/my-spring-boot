package com.aditya.myspringboot.repository;

import com.aditya.myspringboot.model.NextSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class NSRepository {
    @Autowired
    ReactiveMongoTemplate reactiveMongoTemplate;


    public Mono<NextSequence> getNextSequence(String model) {
        Mono<NextSequence> nextSequenceMono = reactiveMongoTemplate.findAndModify(Query.query(Criteria.where("_id").is(model)),
                new Update().inc("sequence",1),
                FindAndModifyOptions.options().returnNew(true).upsert(true),
                NextSequence.class);

        return nextSequenceMono;
    }
}
