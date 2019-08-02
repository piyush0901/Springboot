package com.letsstartcoding.springbootrestapiexample.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="Kafkatransactions")
@EntityListeners(AuditingEntityListener.class)
public class KafkaTransactions {


    @Id
    private Long transid;
    private String createdAt;

    private Long userid1;
    private String mobile;
    private Integer amount;
    private String status;


    public Long getTransid() {
        return transid;
    }

    public void setTransid(Long transid) {
        this.transid = transid;
    }

    public Long getUserid1() {
        return userid1;
    }

    public void setUserid1(Long userid1) {
        this.userid1 = userid1;
    }



    public Integer getAmount() {
        return amount;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
