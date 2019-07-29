package com.letsstartcoding.springbootrestapiexample.controller;


import com.letsstartcoding.springbootrestapiexample.dao.EmployeeDAO;
import com.letsstartcoding.springbootrestapiexample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/u1")
public class EmployeeController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    EmployeeDAO employeeDAO;

    /* to save an employee*/
    @PostMapping("/user")
    public Employee createEmployee(@Valid @RequestBody Employee emp) {

        return employeeDAO.save(emp);
    }

    /*to get particular employee*/
    @GetMapping("/user/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid) {
        Employee emp = employeeDAO.findOne(empid);
        if (emp == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(emp);

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid, @Valid @RequestBody Employee empDetails) {
        Employee emp = employeeDAO.findOne(empid);
        //System.out.println(emp.getName());
        if (emp == null)
            return ResponseEntity.notFound().build();

        //System.out.println(empDetails.getEmail());

        if (empDetails.getName() != null) {
            emp.setName(empDetails.getName());
        }
        if (empDetails.getMobile() != null) {
            emp.setMobile(empDetails.getMobile());
        }
        if (empDetails.getEmail() != null) {
            emp.setEmail(empDetails.getEmail());
        }


        Employee updateEmployee = employeeDAO.save(emp);
        return ResponseEntity.ok().body(updateEmployee);
    }

    public String defaultErrorMessage() {
        return "Request Failed";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
