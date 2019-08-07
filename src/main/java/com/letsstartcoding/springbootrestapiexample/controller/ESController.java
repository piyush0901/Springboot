package com.letsstartcoding.springbootrestapiexample.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsstartcoding.springbootrestapiexample.dao.ESReconDAO;
import com.letsstartcoding.springbootrestapiexample.dao.TransactionDAO;
import com.letsstartcoding.springbootrestapiexample.elasticrepository.ESRepository;
import com.letsstartcoding.springbootrestapiexample.model.ESRecon;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/es")
public class ESController {

    @Autowired
    ESReconDAO esReconDAO;

    @Autowired
    ESRepository esRepository;

    @Autowired
    TransactionDAO transactionDAO;

    @GetMapping("/find")
    //@JsonIgnore
    public List<ESRecon> findAll(){

        Iterable<ESRecon> itr = esRepository.findAll();
        System.out.println("h");
        List<ESRecon> target = new ArrayList<>();;
        itr.forEach(target::add);
        return target;
    }

    @RequestMapping("/recon")
    public String recons(){

        List<Transactions> transactions = transactionDAO.findAll();

        int at,aest;
        long ut,uest;

        for(int i=0;i<transactions.size();i++)
        {
            long t=i+1;
            ESRecon esRecon = esRepository.findOne(t);
            at = transactions.get(i).getAmount();
            aest = esRecon.getAmount();

            ut = transactions.get(i).getUserid1();
            uest = esRecon.getUserid1();

            if(at!=aest)
                return "Error in amount";
            if(!transactions.get(i).getStatus().equals(esRecon.getStatus()))
                return "Error in status";
            if(ut!=uest)
                return "Error in sender's id";
            if(!transactions.get(i).getMobile().equals(esRecon.getMobile()))
                return "Error in receiver's mobile";
        }

        return "Data Consistent";

    }

}
