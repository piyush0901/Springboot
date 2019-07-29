package com.letsstartcoding.springbootrestapiexample.repository;

import com.letsstartcoding.springbootrestapiexample.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    Transactions findOne(Long userid1);

    Transactions findByUserid1(Long userid1);

    Transactions findByMobile(String mobile);


}
