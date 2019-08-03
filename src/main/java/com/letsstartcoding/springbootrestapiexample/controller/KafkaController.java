package com.letsstartcoding.springbootrestapiexample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.letsstartcoding.springbootrestapiexample.dao.OffsetDAO;
import com.letsstartcoding.springbootrestapiexample.dao.TransactionDAO;
import com.letsstartcoding.springbootrestapiexample.model.Offset;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import com.letsstartcoding.springbootrestapiexample.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/kafka")
@Component
@EnableScheduling
public class KafkaController {

    @Autowired
    Producer producer;

    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    OffsetDAO offsetDAO;


    @Scheduled(fixedRate = 300000)
    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic() throws JsonProcessingException {

        Offset off = offsetDAO.findOne(1);
        List<Transactions> trans =  transactionDAO.findAll();
        producer.sendMessage(trans,off);
        off.setValue(trans.size());
        offsetDAO.save(off);
        return "Done";
    }

}
