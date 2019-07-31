package com.letsstartcoding.springbootrestapiexample.dto;

import com.letsstartcoding.springbootrestapiexample.model.Transactions;

import java.util.List;

public class PassbookDTO {

    private Integer balance;

    private List<Transactions> trans;

    private String type;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<Transactions> getTrans() {
        return trans;
    }

    public void setTrans(List<Transactions> trans) {
        this.trans = trans;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
