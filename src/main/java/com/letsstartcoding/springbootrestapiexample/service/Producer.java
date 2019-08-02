package com.letsstartcoding.springbootrestapiexample.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producer {

    String TOPIC = "users";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(List<Transactions> trans) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        for(int i=0;i<trans.size();i++){
            kafkaTemplate.send(TOPIC,mapper.writeValueAsString(trans.get(i)));
        }
        System.out.println("Hi");
    }

}
