package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.model.Wallet;
import com.letsstartcoding.springbootrestapiexample.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletDAO {

    @Autowired
    WalletRepository walletRepository;

    /*to save an wallet*/
    public Wallet save (Wallet wal){
        //System.out.println("beat me");
        return walletRepository.save(wal);
    }


    /*get an wallet by walletid*/
    public Wallet findOne(Long walid){

        return walletRepository.findOne(walid);
    }

    /* get a wallet by user id*/
    public Wallet findByUserid(Long userid){
        return walletRepository.findByUserid(userid);
    }

}
