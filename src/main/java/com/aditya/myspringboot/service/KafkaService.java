package com.aditya.myspringboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Arrays;

@Component
public class KafkaService {
    @Autowired
    KafkaProducer<String,Object> kafkaProducer;

    @Value("${kafka.topicName}")
    String globalTopicName;

    @Autowired
    ObjectMapper mapper;
    @Autowired
    KafkaConsumer<String, String> kafkaConsumer;

    public void produce(String topicName, Object message) {
        ProducerRecord<String,Object> record = null;
        try {
            record = new ProducerRecord<>(topicName!=null?topicName:globalTopicName,mapper.writeValueAsString(message));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaProducer.send(record);
        kafkaProducer.flush();
        //kafkaProducer.close();
    }

    public void consume(String topicName){
        kafkaConsumer.


                subscribe(Arrays.asList(topicName));

        while(true){
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));

            for(ConsumerRecord<String,String> record:records){
                System.out.println("Key: "+record.key()+", Value: "+record.value());
                System.out.println("Partition: "+record.partition()+", Offset: "+record.offset());
            }
        }
    }
}
