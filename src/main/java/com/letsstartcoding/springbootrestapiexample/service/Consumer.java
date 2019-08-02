package com.letsstartcoding.springbootrestapiexample.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letsstartcoding.springbootrestapiexample.dao.KafkaTransactionDAO;
import com.letsstartcoding.springbootrestapiexample.model.KafkaTransactions;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class Consumer {


    @Autowired
    KafkaTransactionDAO kafkaTransactionDAO;

    @KafkaListener(id = "test-consumer-group" , topics = "users")


    public void consume(String trans2) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        KafkaTransactions trans1 = objectMapper.readValue(trans2,KafkaTransactions.class);

        kafkaTransactionDAO.save(trans1);
    }

}
