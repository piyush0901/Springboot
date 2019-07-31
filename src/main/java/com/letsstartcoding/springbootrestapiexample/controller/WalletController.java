package com.letsstartcoding.springbootrestapiexample.controller;

import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.dao.WalletDAO;
import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/wal")
@RestController

public class WalletController implements ErrorController {

    private static final String PATH="/error";

    @Autowired
    WalletDAO walletDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    /* to save an wallet*/
    @PostMapping("/wallet/{usr_id}")
    public String createWallet(@PathVariable(value="usr_id") Long userid, @Valid @RequestBody Wallet walDetails) {

        Wallet wal=walletDAO.findByUserid(userid);

        Employee emp=employeeDAO.findOne(userid);

        if(wal==null && emp!=null)  {
            walDetails.setUserid(userid);
            walletDAO.save(walDetails);
            return "successfully registered.";
        }
        else if(emp==null){
            return "redirect:/u1/user";
        }
        else
            return "failed";
    }

    /*to get particular wallet*/
    @GetMapping("/wallet/{id}")
    public ResponseEntity<Wallet> getwalletById(@PathVariable(value="id") Long walid){
        Wallet wal=walletDAO.findOne(walid);
        if(wal==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(wal);

    }


        //*to update any particular value*//*
    @PutMapping("/wallet/{id}")
    public ResponseEntity<Wallet> updateWallet(@PathVariable(value="id") Long walid, @Valid @RequestBody Wallet walDetails){
        Wallet wal=walletDAO.findOne(walid);
        wal.setBalance(walDetails.getBalance());

        Wallet updateWallet=walletDAO.save(wal);
        return ResponseEntity.ok().body(updateWallet);

    }

    public String defaultErrorMessage(){
        return "Request Failed";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
