package com.letsstartcoding.springbootrestapiexample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.letsstartcoding.springbootrestapiexample.dao.TransactionDAO;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import com.letsstartcoding.springbootrestapiexample.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    Producer producer;

    @Autowired
    TransactionDAO transactionDAO;

    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic() throws JsonProcessingException {

        List<Transactions> trans =  transactionDAO.findAll();
        //List<Object> trans1;
        //trans.addAll()
        producer.sendMessage(trans);
        return "Done";
    }

}
