package com.letsstartcoding.springbootrestapiexample.controller;

import com.letsstartcoding.springbootrestapiexample.dao.KafkaTransactionDAO;
import com.letsstartcoding.springbootrestapiexample.dao.ReconDAO;
import com.letsstartcoding.springbootrestapiexample.dao.TransactionDAO;
import com.letsstartcoding.springbootrestapiexample.model.KafkaTransactions;
import com.letsstartcoding.springbootrestapiexample.model.Recons;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recon")
public class ReconTransKafka {

    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    KafkaTransactionDAO kafkaTransactionDAO;

    @Autowired
    ReconDAO reconDAO;

    @RequestMapping("/tk")
    public String checking(){

        List<KafkaTransactions> kafkaTransactions = kafkaTransactionDAO.findAll();

        List<Transactions> transactions = transactionDAO.findAll();

        Recons recons = reconDAO.findOne(1);

        for(int i=recons.getReconvalue();i<kafkaTransactions.size();i++)
        {

            if(transactions.get(i).getAmount() != kafkaTransactions.get(i).getAmount())
                return "Error in amount";
            if(transactions.get(i).getStatus().equals(kafkaTransactions.get(i).getStatus()))
                return "Error in status";
            if(transactions.get(i).getUserid1() != kafkaTransactions.get(i).getUserid1())
                return "Error in sender's id";
            if(transactions.get(i).getMobile().equals(kafkaTransactions.get(i).getMobile()))
                return "Error in receiver's mobile";
        }
        recons.setReconvalue(kafkaTransactions.size());
        reconDAO.save(recons);
        return "Data Consistent";

    }

}
