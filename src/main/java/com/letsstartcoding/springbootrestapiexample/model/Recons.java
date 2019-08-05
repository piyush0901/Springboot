package com.letsstartcoding.springbootrestapiexample.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="Recons")
@EntityListeners(AuditingEntityListener.class)

public class Recons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer reconvalue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReconvalue() {
        return reconvalue;
    }

    public void setReconvalue(Integer reconvalue) {
        this.reconvalue = reconvalue;
    }
}
