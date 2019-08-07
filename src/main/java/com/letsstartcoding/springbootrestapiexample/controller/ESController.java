package com.letsstartcoding.springbootrestapiexample.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.letsstartcoding.springbootrestapiexample.dao.ESReconDAO;
import com.letsstartcoding.springbootrestapiexample.elasticrepository.ESRepository;
import com.letsstartcoding.springbootrestapiexample.model.ESRecon;
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

    @GetMapping("/find")
    //@JsonIgnore
    public List<ESRecon> findAll(){

        Iterable<ESRecon> itr = esRepository.findAll();
        System.out.println("h");
        List<ESRecon> target = new ArrayList<>();;
        itr.forEach(target::add);
        return target;
    }

}
