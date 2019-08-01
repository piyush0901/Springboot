package com.letsstartcoding.springbootrestapiexample.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    //private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", id = "test-consumer-group")


    public void consume(String message){

        //logger.info(String.format("$$ -> Consumed Message -> %s",message));
        System.out.println(message);

    }

}
