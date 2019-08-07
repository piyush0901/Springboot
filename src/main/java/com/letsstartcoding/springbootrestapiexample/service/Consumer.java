package com.letsstartcoding.springbootrestapiexample.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letsstartcoding.springbootrestapiexample.dao.ESReconDAO;
import com.letsstartcoding.springbootrestapiexample.dao.KafkaTransactionDAO;
import com.letsstartcoding.springbootrestapiexample.elasticrepository.ESRepository;
import com.letsstartcoding.springbootrestapiexample.model.ESRecon;
import com.letsstartcoding.springbootrestapiexample.model.KafkaTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {


    @Autowired
    KafkaTransactionDAO kafkaTransactionDAO;

    @Autowired
    ESReconDAO esReconDAO;

    @Autowired
    ESRepository esRepository;



    @KafkaListener(topicPartitions = { @TopicPartition(topic = "users", partitions = { "0" }) }, id = "consumer1", containerFactory = "kafkaTransKafkaListenerFactory")
    public void consume1(String trans2) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        KafkaTransactions trans1 = objectMapper.readValue(trans2,KafkaTransactions.class);
        kafkaTransactionDAO.save(trans1);
    }


    @KafkaListener(topicPartitions = { @TopicPartition(topic = "users", partitions = { "0" }) }, id = "consumer2", containerFactory = "esReconKafkaListenerFactory")
    public void consume(String trans2) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        KafkaTransactions trans1 = objectMapper.readValue(trans2,KafkaTransactions.class);

        ESRecon esRecon = new ESRecon();

        esRecon.setId(trans1.getTransid());
        esRecon.setAmount(trans1.getAmount());
        esRecon.setCreatedAt(trans1.getCreatedAt());
        esRecon.setMobile(trans1.getMobile());
        esRecon.setStatus(trans1.getStatus());
        esRecon.setUserid1(trans1.getUserid1());

        System.out.println("Hello");
        esReconDAO.save(esRecon);
        ESRecon esRecons = esReconDAO.findOne(esRecon.getId());
        esRepository.save(esRecons);
        System.out.println("Heloebfs");
    }


}
