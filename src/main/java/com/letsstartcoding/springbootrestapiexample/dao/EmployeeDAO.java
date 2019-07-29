package com.letsstartcoding.springbootrestapiexample.dao;

import com.letsstartcoding.springbootrestapiexample.model.Employee;
import com.letsstartcoding.springbootrestapiexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeDAO {

    @Autowired
    EmployeeRepository employeeRepository;

    /*to save an employee*/
    public Employee save (Employee emp){
        //System.out.println("beat me");
        return employeeRepository.save(emp);
    }

    /*get an employee by id*/
    public Employee findOne(Long empid){

        return employeeRepository.findOne(empid);
    }

    /*get an employee by mobile*/
    public Employee findByMobile(String mobile){

        return employeeRepository.findByMobile(mobile);
    }


}
