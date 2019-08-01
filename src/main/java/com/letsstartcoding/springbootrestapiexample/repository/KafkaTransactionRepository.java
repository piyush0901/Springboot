package com.letsstartcoding.springbootrestapiexample.repository;

import com.letsstartcoding.springbootrestapiexample.model.KafkaTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaTransactionRepository extends JpaRepository <KafkaTransactions, Long> {
}
