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

    //private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "users", id = "test-consumer-group")

    public void consume(String trans2) throws IOException {
        //@Autowired
        KafkaTransactionDAO kafkaTransactionDAO = new KafkaTransactionDAO();
        //logger.info(String.format("$$ -> Consumed Message -> %s",message));
        System.out.println(trans2);
        ObjectMapper objectMapper = new ObjectMapper();
        KafkaTransactions trans1 = objectMapper.readValue(trans2,KafkaTransactions.class);
        /*trans1.setUserid1(trans2.userid1());
        trans1.setAmount(trans2.getAmount());
        trans1.setCreatedAt(trans2.getCreatedAt());
        trans1.setMobile(trans2.getMobile());
        trans1.setStatus(trans2.getStatus());*/
        kafkaTransactionDAO.save(trans1);
    }

}
