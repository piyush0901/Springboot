package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.elasticrepository.ESRepository;
import com.letsstartcoding.springbootrestapiexample.model.ESRecon;
import com.letsstartcoding.springbootrestapiexample.repository.ESReconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ESReconDAO {

    @Autowired
    ESReconRepository esReconRepository;

    public ESRecon save(ESRecon esRecon){
        return esReconRepository.save(esRecon);
    }

    public Iterable<ESRecon> findAll(){
        return esReconRepository.findAll();
    }

    public ESRecon findOne(long id){
        return esReconRepository.findOne(id);
    }


}
