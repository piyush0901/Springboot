package com.letsstartcoding.springbootrestapiexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    String TOPIC = "users";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;// new KafkaTemplate<String, String>(props);

    public void sendMessage(String message){

        //KafkaTemplate<String,String> kafkaTemplate = null;
        kafkaTemplate.send(TOPIC,message);
        System.out.println("Hi");
    }

}
