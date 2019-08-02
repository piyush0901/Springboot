package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.model.KafkaTransactions;
import com.letsstartcoding.springbootrestapiexample.repository.KafkaTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KafkaTransactionDAO {

    @Autowired
    KafkaTransactionRepository kafkaTransactionRepository;

    /*to save an T1*/
    public KafkaTransactions save(KafkaTransactions trans) {
        return kafkaTransactionRepository.save(trans);
    }
}