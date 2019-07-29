package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import com.letsstartcoding.springbootrestapiexample.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.Target;

@Service
public class TransactionDAO {

    @Autowired
    TransactionRepository transactionRepository;


    /*to save a transaction*/
    public Transactions save (Transactions trans){
        return transactionRepository.save(trans);
    }

    /*get a transaction by id*/
    public Transactions findOne(Long transid){

        return transactionRepository.findOne(transid);
    }

    public Transactions findByUserid1(Long userid1){

        return transactionRepository.findByUserid1(userid1);
    }

    public Transactions findByMobile(String mobile){

        return transactionRepository.findByMobile(mobile);
    }

}
