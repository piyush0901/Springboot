package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.model.Offset;
import com.letsstartcoding.springbootrestapiexample.repository.OffsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffsetDAO {

    @Autowired
    OffsetRepository offsetRepository;

    /*to save offset*/
    public Offset save (Offset off){
        //System.out.println("beat me");
        return offsetRepository.save(off);
    }
    public Offset findOne(long id) {

        return offsetRepository.findOne(id);
    }
}
