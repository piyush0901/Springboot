package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.model.Recons;
import com.letsstartcoding.springbootrestapiexample.repository.ReconRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReconDAO {

    @Autowired
    ReconRepository reconRepository;

    public Recons save(Recons recons){
        return reconRepository.save(recons);
    }

    public Recons findOne(long id){
        return reconRepository.findOne(id);
    }

}
