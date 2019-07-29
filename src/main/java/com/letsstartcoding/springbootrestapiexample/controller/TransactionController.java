package com.letsstartcoding.springbootrestapiexample.controller;


import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.dao.TransactionDAO;
import com.letsstartcoding.springbootrestapiexample.dao.WalletDAO;
import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import com.letsstartcoding.springbootrestapiexample.model.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/trans")
public class TransactionController implements ErrorController {

    private static final String PATH="/error";

    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    WalletDAO walletDAO;

    @Autowired
    EmployeeDAO employeeDAO;

    /*to save a transaction*/
    @PostMapping("/ts")

    public String createTransaction(@Valid @RequestBody Transactions transactions){

        Integer amount = transactions.getAmount();
        Long u1 = transactions.getUserid1();
        String mobile = transactions.getMobile();

        Wallet wal1=walletDAO.findOne(u1);
        Employee emp=employeeDAO.findByMobile(mobile);

        Long u2= emp.getId();
        Wallet wal2=walletDAO.findOne(u2);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date=new Date();

        if(wal1.getBalance()>=amount)
        {
            wal1.setBalance(wal1.getBalance()-amount);
            wal2.setBalance(wal2.getBalance()+amount);
            transactions.setStatus("Success");
            transactions.setCreatedAt(formatter.format(date));
            transactionDAO.save(transactions);
            return "Success";
        }
        else if(wal1.getBalance()<amount) {
            wal1.setBalance(wal1.getBalance());
            wal2.setBalance(wal2.getBalance());
            transactions.setStatus("Failed");
            transactions.setCreatedAt(formatter.format(date));
            transactionDAO.save(transactions);
            return "Success-failure";
        }
        else
            return "failed";
    }

    @GetMapping("/ts/{id}")
    public ResponseEntity<Transactions> gettransactionById(@PathVariable(value="id") Long transid){
        Transactions trans=transactionDAO.findOne(transid);
        if(trans==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(trans);

    }

    @GetMapping("/pass/{id}")
    public ResponseEntity<Transactions> getpassbookById(@PathVariable(value="id") Long userid){

        //Transactions trans=transactionDAO.findOne(userid);

        Transactions trans = transactionDAO.findByUserid1(userid);
        Employee emp = employeeDAO.findOne(userid);
        String mobile = emp.getMobile();

        Transactions trans1 = trans;
        trans1 = transactionDAO.findByMobile(mobile);

        Wallet wal = walletDAO.findByUserid(userid);

        if(trans1==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(trans1);
        //return ResponseEntity.notFound().build();

    }


    public String defaultErrorMessage(){
        return "Request Failed";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }


}
