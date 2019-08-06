package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.model.ESRecon;
import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.repository.ESReconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ESReconDAO {

    @Autowired
    ESReconRepository esReconRepository;

    public ESRecon save(ESRecon esRecon){
        return esReconRepository.save(esRecon);
    }

}
